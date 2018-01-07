package br.inatel.fredlaranjo.dm110.poller.ejb.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.inatel.fredlaranjo.dm110.poller.ejb.entity.Device;

@Stateless
public class PollerDAO {

	@PersistenceContext(unitName = "poller")
	private EntityManager em;

	public Device getStatus(String ip) {
		return em.createQuery("from device_status ds where ip = " + ip, Device.class).getSingleResult();
	}

	public void insert(Device device) {
		try {
			em.persist(device);
		} catch (EntityExistsException ex) {
			em.merge(device);
		}
	}

}