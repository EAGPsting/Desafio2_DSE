package com.ecodeup.app;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class JPAUtil {
	private static final String PERSISTENCE_UNIT_NAME = "PERSISTENCE";
	private static EntityManagerFactory factory;
	private static EntityManager entityManager;

	public static EntityManagerFactory getEntityManagerFactory() {
		if (factory==null) {
			factory=Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
			entityManager = factory.createEntityManager();
		}
		return factory;				
	}
	public static void shutdown() {
		if (factory!=null) {
			factory.close();
		}		
	}
}