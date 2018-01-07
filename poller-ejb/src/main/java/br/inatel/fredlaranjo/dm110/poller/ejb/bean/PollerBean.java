package br.inatel.fredlaranjo.dm110.poller.ejb.bean;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ws.rs.NotFoundException;

import br.inatel.fredlaranjo.dm110.poller.api.model.DeviceModel;
import br.inatel.fredlaranjo.dm110.poller.ejb.client.interfaces.PollerLocal;
import br.inatel.fredlaranjo.dm110.poller.ejb.client.interfaces.PollerRemote;
import br.inatel.fredlaranjo.dm110.poller.ejb.converter.DeviceConverter;
import br.inatel.fredlaranjo.dm110.poller.ejb.dao.PollerDAO;

@Stateless
@Remote(PollerRemote.class)
@Local(PollerLocal.class)
public class PollerBean implements PollerRemote, PollerLocal {

	@EJB
	private MessagePublisher messagePublisher;

	@EJB
	private PollerDAO pollerDAO;

	@EJB
	private NetworkIpGen networkIpGen;

	private DeviceConverter deviceConverter = new DeviceConverter();

	@Override
	public void startPollDevices(String ip, int mask) {
		String[] ips = networkIpGen.generateIps(ip, mask);

		List<String> msgEnvelope = new ArrayList<>();
		for (int i = 0; i < ips.length; i++) {
			if (msgEnvelope.size() < 10) {
				msgEnvelope.add(ips[i]);
			} else {
				messagePublisher.sendMessage(msgEnvelope);
				msgEnvelope.clear();
				msgEnvelope.add(ips[i]);
			}
		}
		if (!msgEnvelope.isEmpty()) {
			messagePublisher.sendMessage(msgEnvelope);
			msgEnvelope.clear();
		}
	}

	@Override
	public DeviceModel getDeviceStatus(String ip) {
		DeviceModel device = deviceConverter.convertToDeviceModel(pollerDAO.getStatus(ip));

		if (device == null) {
			throw new NotFoundException("Não encontrado device ip:" + ip);
		}

		return device;
	}

}