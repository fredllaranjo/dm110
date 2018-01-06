package br.inatel.fredlaranjo.dm110.poller.api.model;

import java.io.Serializable;

public class DeviceModel implements Serializable {

	private static final long serialVersionUID = 5430511629618442353L;
	private String ip;
	private DeviceStatus status;

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public DeviceStatus getStatus() {
		return status;
	}

	public void setStatus(DeviceStatus status) {
		this.status = status;
	}

}
