package com.acadgild;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.acadgild.DAO.BooksDao;
import com.acadgild.model.Books;

/**
 * Servlet implementation class BooksServlet
 */
public class BooksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String publication = request.getParameter("publication");
		String publicationYear = request.getParameter("publicationyear");
		String price = request.getParameter("price");
		
		Books book = new Books();
		book.setTitle("AcadGild");
		book.setAuthor("Ashish");
		book.setPrice("100");
		book.setPublication("Acad Gild Pub");
		book.setPublicationtyear("2017");
		
		
		BooksDao bookDao = new BooksDao();
		bookDao.insert(book);
		
		
	}

}
