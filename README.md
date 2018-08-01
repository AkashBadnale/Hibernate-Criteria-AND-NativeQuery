# Hibernate NativeQuery

lets say we have entity class as “EmployeeDetails” 

@Entity \
@Table(name="Employee_Details") \
@NamedNativeQueries({ \
           @NamedNativeQuery(name="getAllEmployees", query="select * from employee_details"), \
           @NamedNativeQuery(name="getSpecificEmployee", query="select * from employee_details where id=:id") \
}) \
@NamedQueries({ \
	@NamedQuery(name="getAll", query="from EmployeeDetails"), \
	@NamedQuery(name="getSpecific", query="from EmployeeDetails where id=:id") \
}) \
public class EmployeeDetails { ……  } 

in Test class \
List <EmployeeDetails> employee = session.getNamedQuery("getSpecific").setParameter("id", 5).getResultList();

List <EmployeeDetails> emp=session.getNamedNativeQuery("getSpecificEmployee").setParameter("id", 7).addEntity(EmployeeDetails.class).list();

@NamedQueries --   use these when you want to use HQL QUERY multiple times in your application  \
@NamedNativeQueries – use these when you want to use some DB specific query in your application multiple times .
