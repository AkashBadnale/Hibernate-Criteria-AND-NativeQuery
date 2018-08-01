package com.ab.utilities;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private  static   SessionFactory   sessionFactory  = null ;
	private  static  Session  session  = null;
	
	public  static  Session  getSession () {
		 if(sessionFactory == null) {
			 
				 sessionFactory  =  new  Configuration().configure().buildSessionFactory();
				 session  = sessionFactory.openSession();
				 return  session;
			
		}//if
		 session = sessionFactory.openSession();
		 return session;
	}//getSession
	
	public  static  void  flushNcommit(Session  session  ,  Transaction  tx ) {
		if( session != null) {
			session.flush();
		}
		if(tx != null) {
			tx.commit();
		}
	}//flushNcommit
}//Hibernate
