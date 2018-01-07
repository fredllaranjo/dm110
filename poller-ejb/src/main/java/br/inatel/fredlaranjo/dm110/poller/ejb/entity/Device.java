package br.inatel.fredlaranjo.dm110.poller.ejb.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import br.inatel.fredlaranjo.dm110.poller.api.model.DeviceStatus;

@Entity
@Table(name = "device_status")
public class Device implements Serializable {

	private static final long serialVersionUID = 6733093310278587819L;

	@Id
	private String ip;

	@Enumerated(EnumType.STRING)
	private DeviceStatus status;

	public Device() {
	}

	public Device(String ip, DeviceStatus status) {
		this.ip = ip;
		this.status = status;
	}

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
