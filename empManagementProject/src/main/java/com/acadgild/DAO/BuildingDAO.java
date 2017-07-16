package com.acadgild.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.acadgild.Entity.Building;
import com.acadgild.Entity.Employee;
import com.acadgild.Entity.Floors;
import com.acadgild.Entity.SeatAllotment;

public class BuildingDAO {

	SessionFactory sessionFactory = new Configuration().configure()
			.buildSessionFactory();

	public List<Building> getSeats() {

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		List<Building> list = session.createQuery("From Building").list();

		session.getTransaction().commit();
		session.close();
		return list;

	}

	public List<Floors> selectSeatFromFloor(int floor) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Query createQuery = session
				.createQuery(" From Floors where FloorNo =:floor");
		createQuery = createQuery.setParameter("floor", floor);
		List<Floors> list = createQuery.list();

		return list;
	}

	public void seatChosen(int floor) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"/../dispatcher-servlet.xml");
		SeatAllotment seatAllotment = (SeatAllotment) context
				.getBean("seatAllotment");

		seatAllotment.setEmpId(1);
		seatAllotment.setBuildingId(1);
		seatAllotment.setRequestedByUser("Ashish");
		seatAllotment.setFloorNo(1);
		seatAllotment.setSeatNo(1);
		seatAllotment.setAdminStatusUpdate("Not Updated");
		seatAllotment.setSeatStatus("Requested");

		session.save(seatAllotment);
		session.getTransaction().commit();
		session.close();
	}

	public List<SeatAllotment> seatBooked() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Query createQuery = session
				.createQuery(" From SeatAllotment ");
		
		List<SeatAllotment> list = createQuery.list();
		session.getTransaction().commit();
		session.close();

		return list;
		
	}

	//updateSeatStatus
	
	public void updateSeatStatus(String seatNo,String floorNo,String buildingId) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Query createQuery = session
				.createQuery(" update  SeatAllotment set seatStatus =:status where  seatNo =:seatNo");
		
		
		
		createQuery.setString("status", "Assigned");
		createQuery.setString("seatNo", seatNo);
		
		createQuery.executeUpdate();
		
		session.getTransaction().commit();
		session.close();

		
		
	}
	
	
}
