package com.ab.criteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.ab.utilities.HibernateUtil;

public class TestingCriteria {

	@SuppressWarnings({ "deprecation", "unused", "unchecked" })
	public static void main(String[] args) {
		
		Session session = null;
		Transaction tx = null;
		
		try {
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			
			/*Citizenship c1 = new Citizenship("James", "Gosling", 123456, 789456);
			Citizenship c2 = new Citizenship("Gavin", "King", 123457, 789457);
			Citizenship c3 = new Citizenship("Rod", "Johnsson", 123458, 789458);
			Citizenship c4 = new Citizenship("Jason", "Bourne", 123459, 789459);
			Citizenship c5 = new Citizenship("James", "Bond", 123451, 789451);
			
			session.save(c1);
			session.save(c2);
			session.save(c3);
			session.save(c4);
			session.save(c5);*/
			
			/*     equivalent to ==  select * from citizenship   */
			Criteria criteria = session.createCriteria(Citizenship.class);
			List<Citizenship> listOfCitizens = criteria.list();
			System.out.println(listOfCitizens);
			
			/*    equivalent to ==  select * from citizenship where   name ='James'    */
			Criteria criteria2 = session.createCriteria(Citizenship.class);
			criteria2.add(Restrictions.eq("name", "James"));
			List<Citizenship> listOfEmployeesWithNameJames = criteria2.list();
			System.out.println(listOfEmployeesWithNameJames);
			
			/*  equivalent to ==  select * from citizenship where aadhar > 123457    */
			Criteria criteria3 = session.createCriteria(Citizenship.class);
			criteria3.add(Restrictions.gt("aadharNumber", (long) 123457));
			List<Citizenship> listOfEmployeesGT = criteria3.list();
			System.out.println(listOfEmployeesGT);
			
			/*   equivalent to ==  select * from citizenship where surname like 'Bo%';  */
			List<Citizenship> listOfEmp = session.createCriteria(Citizenship.class).add(Restrictions.ilike("surname", "Bo%")).list();
			System.out.println(listOfEmp);
			
			/*   equivalent to ==  select * from citizenship where passport between 789457 and 789459 ; */
			List<Citizenship> listOfEmps = session.createCriteria(Citizenship.class).add(Restrictions.between("passportNumber", (long) 789457, (long) 798459)).list();
			System.out.println(listOfEmps);
			
			/*  equivalent to ==  select * from citizenship where name='James' and surname like 'B%';   */
			Criteria  criteria4 = session.createCriteria(Citizenship.class);
			Criterion  name = Restrictions.eq("name", "James");
			Criterion  surname = Restrictions.ilike("surname" , "B%");
			LogicalExpression andEx = Restrictions.and(name,surname);
			List<Citizenship> list = criteria4.add(andEx).list();
			System.out.println(list);
			
			/*   equivalent  to  ==   select max(aadhar) from citizenship   */
			Criteria criteria5 =  session.createCriteria(Citizenship.class).setProjection(Projections.max("aadharNumber"));
			List<Citizenship> listOfRecords = criteria5.list();
			System.out.println(listOfRecords);
			
			
			
			HibernateUtil.flushNcommit(session, tx);
		} catch (Exception e) {
			tx.rollback();
             e.printStackTrace();
		}finally {
			session.close();
		}
	}//main
}//TestingCriteria
