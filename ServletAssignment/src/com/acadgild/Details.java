package com.acadgild;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Details
 */
public class Details extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String email = request.getParameter("email");
		
		if(firstName.equals(null))
		{
			firstName="default";
		}
		if(lastName.equals(null))
		{
			lastName="default";
		}
		if(email.equals(null))
		{
			email="default";
		}
		
		
	}

}
