package com.acadgild.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.acadgild.Employee3;

@Controller
@RequestMapping("/employee/add.htm")
public class EmployeeController {
	@RequestMapping(method = RequestMethod.GET)
	ModelAndView add(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Employee3 employee = new Employee3();
		return new ModelAndView("addemployee", "employee", employee);

	}
}
