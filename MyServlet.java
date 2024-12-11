package com.first;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req,HttpServletResponse resp) {
		Cookie c1=new Cookie("username","subha");
		Cookie c2=new Cookie("password","subha@123");
		resp.addCookie(c1);
		resp.addCookie(c2);
		System.out.println("cookies created");
		
		
	}

}
