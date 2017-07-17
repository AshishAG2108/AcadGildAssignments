package com.acadgild;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CreateServlet
 */
public class CreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String name = request.getParameter("user");
        String pass = request.getParameter("pass");
        
        if(pass.equals("1234"))
        {
            //creating a session
            HttpSession session = request.getSession();
           // session.setAttribute("user", name);
            response.sendRedirect(session.toString());
        }
    }
}
