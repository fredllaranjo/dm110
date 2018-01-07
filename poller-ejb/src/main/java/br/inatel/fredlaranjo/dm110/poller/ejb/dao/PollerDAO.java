package br.inatel.fredlaranjo.dm110.poller.ejb.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.inatel.fredlaranjo.dm110.poller.ejb.entity.Device;

@Stateless
public class PollerDAO {

	@PersistenceContext(unitName = "poller")
	private EntityManager em;

	public Device getStatus(String ip) {
		return em.find(Device.class, ip);
	}

	public void insert(Device device) {
		em.merge(device);
	}

}