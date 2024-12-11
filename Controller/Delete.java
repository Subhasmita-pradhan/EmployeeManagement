package com.first.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.first.Service.EmpService;

@WebServlet("/delete")
public class Delete extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id1=req.getParameter("id");
		
		int id=Integer.parseInt(id1);
		EmpService emp=new EmpService();
		int  no2=emp.delete(id);
		if(no2>0) {
			 RequestDispatcher dispatcher=req.getRequestDispatcher("welcome.html");
			  dispatcher.forward(req, resp);
		}
		else {
			 RequestDispatcher dispatcher=req.getRequestDispatcher("Delete.html");
			  dispatcher.forward(req, resp);
		}
	}

}