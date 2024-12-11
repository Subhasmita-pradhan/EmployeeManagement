package com.first;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/home")
public class Last extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession();
		String user=(String) session.getAttribute("username");
		String pwd=(String) session.getAttribute("password");
		if(user.equals("Subha") && pwd.equals("Subha@123")) {
			session.invalidate();
			RequestDispatcher rd=req.getRequestDispatcher("login.html");
			rd.forward(req, resp);
		}
		else {
			PrintWriter out=resp.getWriter();
			out.print("<h1>Invalid username password <br>"
					+ "Session  Deleted</h1>");
		}
		
	}
	

}
