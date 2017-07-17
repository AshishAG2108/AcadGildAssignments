package com.acadgild;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Deblink extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		String contentType = req.getContentType(); // get the incoming type
		if (contentType == null)
			return; // nothing incoming, nothing to do
		res.setContentType(contentType); // set outgoing type to be incoming
											// type

		PrintWriter out = res.getWriter();

		BufferedReader in = req.getReader();

		String line = null;
		while ((line = in.readLine()) != null) {
			line = replace(line, "<BLINK>", "");
			line = replace(line, "</BLINK>", "");
			out.println(line);
		}
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doGet(req, res);
	}

	private String replace(String line, String oldString, String newString) {
		int index = 0;
		while ((index = line.indexOf(oldString, index)) >= 0) {
			// Replace the old string with the new string (inefficiently)
			line = line.substring(0, index) + newString
					+ line.substring(index + oldString.length());
			index += newString.length();
		}
		return line;
	}
}