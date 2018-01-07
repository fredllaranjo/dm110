package br.inatel.fredlaranjo.dm110.poller.core;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;

import br.inatel.fredlaranjo.dm110.poller.api.PollerService;
import br.inatel.fredlaranjo.dm110.poller.api.model.DeviceModel;
import br.inatel.fredlaranjo.dm110.poller.ejb.client.interfaces.PollerRemote;

@RequestScoped
public class PollerServiceImpl implements PollerService {

	@EJB(lookup = "java:app/poller-ejb-0.1-SNAPSHOT/PollerBean!br.inatel.fredlaranjo.dm110.poller.ejb.client.interfaces.PollerRemote")
	private PollerRemote poller;

	@Override
	public void startPollDevices(String ip, int mask) {
		poller.startPollDevices(ip, mask);
	}

	@Override
	public DeviceModel getDeviceStatus(String ip) {
		return poller.getDeviceStatus(ip);
	}

}
