package com.acadgild.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Converter
 */
public class Converter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
public String temp=null;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest in, HttpServletResponse output) throws ServletException, IOException {
		output.setContentType("text/html");
        PrintWriter out = output.getWriter();

        out.println("<html><head><title>Temperature Conversion</title></head>");
        out.println("<body>");
        out.println("<h1>Degrees F to degrees C conversion</h1>");
        if (temp != null ) {
                String supplied_temp = temp;
                float base_temp = -999;
                boolean valid = false;
                try {
                        base_temp = Float.parseFloat(supplied_temp);
                        valid = true;
                    }
                catch (NumberFormatException e) {
                        out.println("<h4><font color=red>"+
                        "Invalid Temperature Supplied</font></h4)<br>");
                }
                if ( valid ) {
                        out.println("<h4>Temperature " +
                                base_temp +
                                " deg f converts to " +
                                ((((float)base_temp - 32.0f)
                                        / 9.0f ) * 5.0f) +
                                " deg celcius </h4>");
                }
        }

        out.println("</body></html>");
        out.close();
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest in, HttpServletResponse output) throws ServletException, IOException {
		
		temp = in.getParameter("temp") ;
		doGet(in,output);
	}

}
