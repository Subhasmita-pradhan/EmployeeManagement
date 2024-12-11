package com.first.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.first.Entity.Employee;
import com.first.Service.EmpService;
@WebServlet("/save")
public class SaveEmp extends HttpServlet {
private RequestDispatcher dispatcher;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id=req.getParameter("id");
		String name=req.getParameter("name");
		String age=req.getParameter("age");
		String email=req.getParameter("email");
		String salary=req.getParameter("salary");
		String password=req.getParameter("password");
		
	int id1=Integer.parseInt(id);
	int age1=Integer.parseInt(age);
	double salary1=Double.parseDouble(salary);
	
	Employee e1=new Employee(id1,name,age1,email,salary1,password);
	EmpService service= new EmpService();
	int no=service.saveEmp(e1);
	if(no!=0) {
		dispatcher=req.getRequestDispatcher("welcome.html");
		dispatcher.forward(req, resp);
		
	}
	else
	{
		PrintWriter print=resp.getWriter();
		print.write("<h1>Data not saved</h1>");
	}
	
	
		
		
	}
	
	

}
