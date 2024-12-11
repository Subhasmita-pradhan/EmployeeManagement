package com.first;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/logout")
public class Second extends HttpServlet {
	protected void doGet(HttpServletRequest req,HttpServletResponse resp) {
		Cookie[] cookies=req.getCookies();
		if(cookies!=null) {
			for(Cookie cookie:cookies) {
				if(cookie.getName().equals("username")) {
					cookie.setMaxAge(5);
					System.out.println("deleted");
				}
				resp.addCookie(cookie);
					
				}
					
			}
			
			
		}
		
	}
	


