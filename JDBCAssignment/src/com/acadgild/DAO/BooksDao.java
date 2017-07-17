package com.acadgild.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.acadgild.model.Books;

public class BooksDao {

	public void selectAll() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/books", "root", "ganesha2108");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from emp");
			while (rs.next())
				System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  "
						+ rs.getString(3));
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void insert(Books book) {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/books", "root", "ganesha2108");
			
			Statement stmt = con.createStatement();
			String sql = "INSERT INTO Registration "
					+ "VALUES (100, "+book.getAuthor()+","+book.getPrice()+","+book.getPublication()+","+
					book.getPublicationtyear()+","+book.getTitle()+")";
			stmt.executeUpdate(sql);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void delete(Books book) {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/books", "root", "ganesha2108");
			
			Statement stmt = con.createStatement();
			String sql = "delete from Registration where title="
					+ book.getTitle();
			stmt.executeUpdate(sql);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
