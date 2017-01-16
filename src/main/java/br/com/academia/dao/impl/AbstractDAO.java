package br.com.academia.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class AbstractDAO {
	
	@PersistenceContext(unitName="jpa-persistence")
	private EntityManager em;

	public EntityManager getEntityManager() {
		return em;
	}

	public void setEntityManager(EntityManager em) {
		this.em = em;
	}

}
