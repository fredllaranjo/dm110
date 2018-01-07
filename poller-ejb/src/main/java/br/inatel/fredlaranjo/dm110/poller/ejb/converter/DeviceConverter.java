package br.inatel.fredlaranjo.dm110.poller.ejb.converter;

import br.inatel.fredlaranjo.dm110.poller.api.model.DeviceModel;
import br.inatel.fredlaranjo.dm110.poller.ejb.entity.Device;

public class DeviceConverter {

	public DeviceModel convertToDeviceModel(Device device) {
		DeviceModel deviceModel = null;
		if (device != null) {
			deviceModel = new DeviceModel(device.getIp(), device.getStatus());
		}
		return deviceModel;
	}

}
