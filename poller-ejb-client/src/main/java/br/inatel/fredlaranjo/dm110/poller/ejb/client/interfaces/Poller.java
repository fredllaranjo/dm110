package br.inatel.fredlaranjo.dm110.poller.ejb.client.interfaces;

import br.inatel.fredlaranjo.dm110.poller.api.model.DeviceModel;

public interface Poller {

	void startPollDevices(String ip, int mask);

	public DeviceModel getDeviceStatus(String ip);

}
