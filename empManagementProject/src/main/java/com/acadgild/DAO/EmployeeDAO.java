package com.acadgild.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.acadgild.Entity.Employee;

public class EmployeeDAO {

	
	
	public void addEmployee(Employee employee)
	{
		if(employee!=null)
		{
			 SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();  
		     Session session = sessionFactory.openSession();
		     session.beginTransaction();
		     
		     session.save(employee);
		     session.getTransaction().commit();
		     session.close();
		     
			
		     System.out.println("Data Saved");
		}
	}
	
	public boolean validateUser(String name,String password)
	{
		if(name!=null && password!=null)
		{
			 SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();  
		     Session session = sessionFactory.openSession();
		     session.beginTransaction();
		     
		     Query createQuery = session.createQuery("from Employee where empName = :name");
		     createQuery.setParameter("name", name);
		     
		     List<Employee> list = createQuery.list();
		     
		     if(list.size()>0)return true;
		     
		     session.getTransaction().commit();
		     session.close();
		}
		return false;
	}
	
	
	
}
