package com.ab.nativeQueries;

import java.util.List;

import org.hibernate.Session;

import com.ab.utilities.HibernateUtil;

public class TestNativeQueries {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Session session = null;
		try {
			session = HibernateUtil.getSession();
			
			System.out.println(" Using Named Query -- HQL specific --  GetAll Employees ");
			List<EmployeeDetails>  employees = session.getNamedQuery("getAll").list();
			System.out.println(employees);
			System.out.println(" Using Named Query -- HQL specific -- Get specific Employee");
			List<EmployeeDetails> employee = session.getNamedQuery("getSpecific").setParameter("id", 5).getResultList();
			System.out.println(employee);
			
			System.out.println("Using Named Native Query -- DB specific -- GetAll Employees");
			List<EmployeeDetails> emps = session.getNamedNativeQuery("getAllEmployees").addEntity(EmployeeDetails.class).list();
			System.out.println(emps);
			System.out.println(" Using Named Native Query -- DB specific -- Get specific employee");
			List<EmployeeDetails> emp = session.getNamedNativeQuery("getSpecificEmployee").setParameter("id", 7).addEntity(EmployeeDetails.class).list();
			System.out.println(emp);
			
		}catch (Exception e) {
             e.printStackTrace();
		}finally {
			session.close();
		}
		
	}//main
}//TestNativeQueries
