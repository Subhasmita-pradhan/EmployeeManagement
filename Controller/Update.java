package com.first.Controller;

	import java.io.IOException;

	import javax.servlet.RequestDispatcher;
	import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;

	import com.first.*;
import com.first.Entity.Employee;
import com.first.Service.*;

	@WebServlet("/update")
	public class Update extends HttpServlet {
		
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String id1=req.getParameter("id");
			int id=Integer.parseInt(id1);
			String name=req.getParameter("name");
			String age1=req.getParameter("age");
			int age=Integer.parseInt(age1);
			String email=req.getParameter("email");
			String sal1=req.getParameter("salary");
			double sal=Double.parseDouble(sal1);
			String password=req.getParameter("password");
			Employee e1=new Employee(id,name,age,email,sal,password);
			
			int no1=EmpService.update(e1);
			if(no1>0) {
				 RequestDispatcher dispatcher=req.getRequestDispatcher("welcome.html");
				  dispatcher.forward(req, resp);
			}
			else {
				 RequestDispatcher dispatcher=req.getRequestDispatcher("Update.html");
				  dispatcher.forward(req, resp);
			}
			
		}


}
