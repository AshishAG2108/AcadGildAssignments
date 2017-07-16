package com.acadgild.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DisplayHeader
 */
public class DisplayHeader extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");  
	      PrintWriter out = response.getWriter();  
	        
	      out.println("HTTP headers sent by your client:<br>");  
	        
	    Enumeration headerNames = request.getHeaderNames();  
	        while (headerNames.hasMoreElements()) {  
	        String headerName = (String) headerNames.nextElement();  
	        String headerValue = request.getHeader(headerName);  
	        out.print("<b>"+headerName + "</b>: ");  
	        out.println(headerValue + "<br>");  
	      }  
		
	}

	

}
