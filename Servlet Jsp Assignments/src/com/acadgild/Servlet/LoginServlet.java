package com.acadgild.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 response.setContentType("text/html");  
	        PrintWriter out=response.getWriter();  
	        request.getRequestDispatcher("link.html").include(request, response);  
	          
	        String name=request.getParameter("name");  
	        String password=request.getParameter("password");  
	          
	        if(password.equals("admin123")){  
	        out.print("Welcome, "+name);  
	        HttpSession session=request.getSession();  
	        session.setAttribute("name",name);  
	        
	        out.println("<h2>Session created Successfully</h2>");
	        
	        out.println(docType +
	                "<html>\n" +
	                   "<head><title>" + title + "</title></head>\n" +
	                   
	                   "<body bgcolor = \"#f0f0f0\">\n" +
	                      "<h1 align = \"center\">" + title + "</h1>\n" +
	                      "<h2 align = \"center\">Session Infomation</h2>\n" +
	                      "<table border = \"1\" align = \"center\">\n" +
	                         
	                         "<tr bgcolor = \"#949494\">\n" +
	                            "  <th>Session info</th><th>value</th>"+
	                         "</tr>\n" +
	                            
	                         "<tr>\n" +
	                            "  <td>id</td>\n" +
	                            "  <td>" + session.getId() + "</td>"+
	                   "</tr>\n" +
	                         
	                         "<tr>\n" +
	                            "  <td>Creation Time</td>\n" +
	                            "  <td>" + createTime + "  </td>"+
	                         "</tr>\n" +
	                         
	                         "<tr>\n" +
	                            "  <td>Time of Last Access</td>\n" +
	                            "  <td>" + lastAccessTime + "  </td>"+
	                         "</tr>\n" +
	                         
	                         "<tr>\n" +
	                            "  <td>User ID</td>\n" +
	                            "  <td>" + userID + "  </td>"+
	                         "</tr>\n" +
	                         
	                         "<tr>\n" +
	                            "  <td>Number of visits</td>\n" +
	                            "  <td>" + visitCount + "</td>"+
	                         "</tr>\n" +
	                      "</table>\n" +
	                   "</body>"+
	                "</html>"
	             );
	        
	        }  
	        else{  
	            out.print("Sorry, username or password error!");  
	            request.getRequestDispatcher("login.html").include(request, response);  
	        }  
	        out.close();  
	}

	

}
