package br.inatel.fredlaranjo.dm110.poller.ejb.entity;

import java.io.Serializable;
import java.util.List;

public class PollerMessage implements Serializable {

	private static final long serialVersionUID = 4474911680024378875L;

	private List<String> ips;

	public PollerMessage(List<String> ips) {
		this.ips = ips;
	}

	public List<String> getIps() {
		return ips;
	}

	public void setIps(List<String> ips) {
		this.ips = ips;
	}
}
