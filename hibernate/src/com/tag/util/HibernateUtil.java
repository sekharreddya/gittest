package com.tag.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtil {

	private static final  SessionFactory sessionFactory;
	
	static {
		
		try {
			sessionFactory=new AnnotationConfiguration().configure().buildSessionFactory();
			}
		catch(Throwable e){
			//sessionFactory.close();
			throw new ExceptionInInitializerError();
			}
		}
	
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
	
}
