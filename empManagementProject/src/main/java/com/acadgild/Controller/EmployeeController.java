package com.acadgild.Controller;

import java.util.List;

import javax.servlet.RequestDispatcher;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import com.acadgild.DAO.BuildingDAO;
import com.acadgild.DAO.EmployeeDAO;
import com.acadgild.Entity.Building;
import com.acadgild.Entity.Employee;
import com.acadgild.Entity.Floors;
import com.acadgild.Entity.SeatAllotment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Controller
public class EmployeeController {

	public String username;
	public String password;

	@Autowired
	EmployeeDAO empDAO;

	@RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
	public ModelAndView checkLogin(
			@RequestParam(value = "name", required = false, defaultValue = "World") String name,
			@RequestParam(value = "salary", required = false, defaultValue = "World") int salary,
			@RequestParam(value = "empId", required = false, defaultValue = "World") int employeeId,
			@RequestParam(value = "empLocation", required = false, defaultValue = "World") String empLocation) {

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"/../dispatcher-servlet.xml");
		Employee emp = (Employee) context.getBean("employee");

		emp.setEmpName(name);
		emp.setEmployeeId(employeeId);
		emp.setEmpLocation(empLocation);
		emp.setEmpSalary(salary);

		empDAO.addEmployee(emp);

		ModelAndView mv = new ModelAndView("helloworld");
		mv.addObject("username", username);
		mv.addObject("password", password);
		return mv;
	}

	@RequestMapping(value = "/validateUser", method = RequestMethod.POST)
	public ModelAndView valudateUser(
			@RequestParam(value = "name", required = false, defaultValue = "World") String name,
			@RequestParam(value = "password", required = false, defaultValue = "World") String password) {

		if(name.equals("admin"))
		{
			ModelAndView mv = new ModelAndView("AdminScreen");
			mv.addObject("username", "Ashish");
			return mv;
		}
		
		if (empDAO.validateUser(name, password)) {
			System.out.println("Employee exists ");
			ModelAndView mv = new ModelAndView("EmployeeWelcome");
			mv.addObject("username", name);
			return mv;
		} else {

			System.out.println("Employee does not exists ");
		}
		return null;
	}

	@Autowired
	BuildingDAO buildingDAO;

	@RequestMapping(value = "/getSeats")
	public ModelAndView getSeats() {

		/*
		 * ApplicationContext context = new ClassPathXmlApplicationContext(
		 * "/../dispatcher-servlet.xml");
		 */

		List<Building> seats = buildingDAO.getSeats();

		ModelAndView mv = new ModelAndView("SelectBuilding");
		mv.addObject("seats", seats);
		return mv;
	}

	@RequestMapping(value = "/getSeatsForAdmin")
	public ModelAndView getSeatsForAdmin() {

		/*
		 * ApplicationContext context = new ClassPathXmlApplicationContext(
		 * "/../dispatcher-servlet.xml");
		 */

		List<SeatAllotment> seatBooked = buildingDAO.seatBooked();

		ModelAndView mv = new ModelAndView("SelectBuildingForAdmin");
		mv.addObject("seats", seatBooked);
		mv.addObject("user","admin");
		return mv;
	}
	
	//assignSeatStatus
	
	
	@RequestMapping(value = "/selectSeatFromFloor", method = RequestMethod.GET)
	public ModelAndView selectSeatFromFloor(
			@RequestParam(value = "floorNo", required = false, defaultValue = "World") int floorNo) {
		System.out.println("floor no selected " + floorNo);

		List<Floors> floorSeats = buildingDAO.selectSeatFromFloor((floorNo));

		ModelAndView mv = new ModelAndView("SelectSeat");
		mv.addObject("selSeat", floorSeats);
		return mv;
	}

	@RequestMapping(value = "/seatSelected")
	public ModelAndView seatSelectByUser(
			@RequestParam(value = "seatNo", required = false, defaultValue = "World") int seatNo) {
		System.out.println("seat no selected " + seatNo);

		buildingDAO.seatChosen((seatNo));

		ModelAndView mv = new ModelAndView("EmployeeWelcome");
		return mv;
	}
	
	
	
	@RequestMapping(value = "/getBookedSeatStatus")
	public ModelAndView seatBooked() {
		List<SeatAllotment> seatBooked = buildingDAO.seatBooked();

		ModelAndView mv = new ModelAndView("BookedStatus");
		mv.addObject("seatStatus",seatBooked);
		return mv;
	}
	
	@RequestMapping(value = "/assignSeatStatus")
	public ModelAndView assignSeatStatus(@RequestParam(value = "seatNo", required = false, defaultValue = "World") String seatNo,
			@RequestParam(value = "floorNo", required = false, defaultValue = "World") String floorNo,
			@RequestParam(value = "buildingId", required = false, defaultValue = "World") String buildingId) {

		 

	 buildingDAO.updateSeatStatus(seatNo,floorNo,buildingId);

		ModelAndView mv = new ModelAndView("AdminScreen");
		mv.addObject("user","admin");
		return mv;
	}
	
	
	
}
