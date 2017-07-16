package com.acadgild.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TimeServlet
 */
public class TimeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 // get information
	      String now = new Date().toString();

	      // set content type to HTML
	      response.setContentType("text/html");

	      response.setIntHeader("Refresh", 10);
	      
	      // print formatted information
	      PrintWriter out = response.getWriter();

	      String title = "Date Servlet";
	      out.println("<html><head><title>");
	      out.println(title);
	      out.println("</title></head><body><h1>");
	      out.print(title);
	      out.println("</h1><p>The current time is: ");
	      out.println(now);
	      out.println("</p></body></html>");

	      out.close();

		
	}

	
}
