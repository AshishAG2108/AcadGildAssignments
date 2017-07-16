package com.acadgild.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletActions
 */
public class ServletActions extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");    
	    PrintWriter out = response.getWriter();
	    
		String parameter = request.getParameter("name");
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("ServletActions2");
		if(parameter.equals("next"))
		{
			requestDispatcher.forward(request, response);
		}
		
		else
		{
		requestDispatcher.include(request,  response);
		}
		out.println("<br><br>Please pay the bill amount before 5th of every month to avoid penalty and disconnection");
		 
	    out.close();
	}

}
