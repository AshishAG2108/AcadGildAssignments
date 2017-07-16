package com.acadgild;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;

import com.acadgild.HelloWorld;

/**
 * Hello world!
 * 
 */
public class App {
	public static void main(String[] args) {
		// first way of setting the app context ref in spring
		ApplicationContext context = new ClassPathXmlApplicationContext("SpringBeans.xml");
		HelloWorld obj = (HelloWorld) context.getBean("helloBean");
		obj.printHello();

		// by creating class which implements appContextAware interface where we
		// can set the context
		AppContext appContextRef = new AppContext();
		appContextRef.setApplicationContext(context);
		HelloWorld hWorld = (HelloWorld) appContextRef.getApplicationContext()
				.getBean("helloBean");
		// hWorld.printHello();

		// setter dependency injection
		Employee e = (Employee) context.getBean("employee");
		e.display();

		// constructor dependency injection
		Employee2 e2 = (Employee2) context.getBean("employee2");
		e2.show();

		// custom property editors
		Person person = (Person) context.getBean("person");
		PersonType ptype = person.getType();
		System.out.println(ptype.getTypeName());

		// BeanProxyFactory
		MyBean bean1 = (MyBean) context.getBean("myBean1");
		MyBean bean2 = (MyBean) context.getBean("myBean2");
		System.out.println("Bean 1");
		bean1.execute();
		System.out.println("\nBean 2");
		bean2.execute();

		// spring jdbc
		StudentJDBCTemplate studentJDBCTemplate = (StudentJDBCTemplate) context
				.getBean("studentJDBCTemplate");

		System.out.println("------Records Creation--------");
		studentJDBCTemplate.create("Ash", 11);
		studentJDBCTemplate.create("Bar", 2);
		studentJDBCTemplate.create("Foo", 15);

		System.out.println("------Listing Multiple Records--------");
		List<Student> students = studentJDBCTemplate.listStudents();

		for (Student record : students) {
			System.out.print("ID : " + record.getId());
			System.out.print(", Name : " + record.getName());
			System.out.println(", Age : " + record.getAge());
		}

		System.out.println("----Updating Record with ID = 2 -----");
		studentJDBCTemplate.update(2, 20);

		System.out.println("----Listing Record with ID = 2 -----");
		Student student = studentJDBCTemplate.getStudent(2);
		System.out.print("ID : " + student.getId());
		System.out.print(", Name : " + student.getName());
		System.out.println(", Age : " + student.getAge());

	//Mutiple inserts of employee object present in list
		List<Employee> emp = new ArrayList<Employee>();
		Employee emp1 = new Employee();
		emp1.setId(1);
		emp1.setName("A");
		emp1.setCity("Bang");
		Employee emp2 = new Employee();
		emp2.setId(2);
		emp2.setName("B");
		emp2.setCity("Delhi");
		emp.add(emp1);
		emp.add(emp2);
        studentJDBCTemplate.insertEmployees(emp);
	}
}
