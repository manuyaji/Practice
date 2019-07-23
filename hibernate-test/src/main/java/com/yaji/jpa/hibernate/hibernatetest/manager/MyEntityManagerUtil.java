package com.yaji.jpa.hibernate.hibernatetest.manager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MyEntityManagerUtil {
	
	private MyEntityManagerUtil(){
		init();
	}
	
	private static MyEntityManagerUtil INSTANCE = new MyEntityManagerUtil();
	
	private EntityManagerFactory emFactory;
	private EntityManager em;
	
	private void init(){
		emFactory = Persistence.createEntityManagerFactory("test");
		em = emFactory.createEntityManager();
	}
	
	public static EntityManagerFactory entitymanagerFactory(){
		return INSTANCE.emFactory;
	}
	
	public static EntityManager entitymanager(){
		return INSTANCE.em;
	}

}
