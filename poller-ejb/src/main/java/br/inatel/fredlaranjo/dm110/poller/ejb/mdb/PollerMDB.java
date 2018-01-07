package br.inatel.fredlaranjo.dm110.poller.ejb.mdb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

import br.inatel.fredlaranjo.dm110.poller.api.model.DeviceStatus;
import br.inatel.fredlaranjo.dm110.poller.ejb.bean.PollerPingRuntime;
import br.inatel.fredlaranjo.dm110.poller.ejb.dao.PollerDAO;
import br.inatel.fredlaranjo.dm110.poller.ejb.entity.Device;
import br.inatel.fredlaranjo.dm110.poller.ejb.entity.PollerMessage;

@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "java:/jms/queue/dm110pollerqueue"),
		@ActivationConfigProperty(propertyName = "maxSession", propertyValue = "4") })
public class PollerMDB implements MessageListener {

	@EJB
	private PollerPingRuntime pollerPingRuntime;

	@EJB
	private PollerDAO pollerDAO;

	@Override
	public void onMessage(Message message) {
		try {
			PollerMessage pollerMessage = message.getBody(PollerMessage.class);

			pollerMessage.getIps().stream().forEach(ip -> {
				Device device;
				if (pollerPingRuntime.execPing(ip)) {
					device = new Device(ip, DeviceStatus.ATIVO);
				} else {
					device = new Device(ip, DeviceStatus.INATIVO);
				}

				pollerDAO.insert(device);
			});
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}
