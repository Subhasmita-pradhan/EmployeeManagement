package com.first;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class first extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String user_name=req.getParameter("username");
	    String password=req.getParameter("password");
	    HttpSession session1= req.getSession();
	    session1.setAttribute("username", user_name);
	    session1.setAttribute("password", password);
	    System.out.println("Session created");
        RequestDispatcher rq= req.getRequestDispatcher("home.html");
        rq.forward(req, res);
	}


		
	}
	



