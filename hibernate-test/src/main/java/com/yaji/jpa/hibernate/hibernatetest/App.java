package com.yaji.jpa.hibernate.hibernatetest;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.yaji.jpa.hibernate.hibernatetest.entity.Student;
import com.yaji.jpa.hibernate.hibernatetest.manager.MyEntityManagerUtil;

import enums.SomeEnum;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	EntityManager em = MyEntityManagerUtil.entitymanager();
    	EntityTransaction et = em.getTransaction();
    	et.begin();
    	em.persist(new Student("EE26","Name2","Address2",Calendar.getInstance().getTime(), SomeEnum.TWO));
    	em.flush();
    	et.commit();
    }
}
