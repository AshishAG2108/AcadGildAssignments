package com.acadgild.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DetailsServlet
 */
public class DetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String age = request.getParameter("age");
		
		PrintWriter writer = response.getWriter();
		writer.println(username+" "+age);
		System.out.println(username+" "+age);
		int intAge = Integer.parseInt(age);
		
		if(intAge>65)
		{
			writer.println("Movie ticket Price "+"$7.00");
			System.out.println("Movie ticket Price "+"$7.00");
		}	
		else if(intAge<10)
		{
			writer.println("Movie ticket Price $5.00");
			System.out.println("Movie ticket Price $5.00");
		}
		else
		{
			writer.println("Movie ticket Price $9.50");
			System.out.println("Movie ticket Price $9.50");
		}
		
		
	}

}
