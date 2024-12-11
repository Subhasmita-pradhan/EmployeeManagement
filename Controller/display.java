package com.first.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.first.Entity.Employee;
import com.first.Service.*;

@WebServlet("/display")
public class display extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EmpService service=new EmpService();
		List<Employee> e1=service.getAll();
		
		   resp.setContentType("text/html");
	        PrintWriter pr = resp.getWriter();

	        // Start of the HTML content
	        pr.write("<!DOCTYPE html>\r\n"
	                + "<html lang=\"en\">\r\n"
	                + "<head>\r\n"
	                + "  <meta charset=\"UTF-8\">\r\n"
	                + "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
	                + "  <title>Employee Details</title>\r\n"
	                + "  <style>\r\n"
	                + "    * {\r\n"
	                + "      margin: 0;\r\n"
	                + "      padding: 0;\r\n"
	                + "      box-sizing: border-box;\r\n"
	                + "    }\r\n"
	                + "    body {\r\n"
	                + "      font-family: Arial, sans-serif;\r\n"
	                + "      background: linear-gradient(to right, #74ebd5, #acb6e5);\r\n"
	                + "      min-height: 100vh;\r\n"
	                + "      display: flex;\r\n"
	                + "      justify-content: center;\r\n"
	                + "      align-items: center;\r\n"
	                + "    }\r\n"
	                + "    .container {\r\n"
	                + "      background: #fff;\r\n"
	                + "      border-radius: 10px;\r\n"
	                + "      box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);\r\n"
	                + "      padding: 20px;\r\n"
	                + "      width: 90%;\r\n"
	                + "      max-width: 800px;\r\n"
	                + "      text-align: center;\r\n"
	                + "    }\r\n"
	                + "    h1 {\r\n"
	                + "      margin-bottom: 20px;\r\n"
	                + "      color: #333;\r\n"
	                + "    }\r\n"
	                + "    table {\r\n"
	                + "      width: 100%;\r\n"
	                + "      border-collapse: collapse;\r\n"
	                + "    }\r\n"
	                + "    thead {\r\n"
	                + "      background: #4caf50;\r\n"
	                + "      color: white;\r\n"
	                + "    }\r\n"
	                + "    th, td {\r\n"
	                + "      padding: 10px;\r\n"
	                + "      text-align: left;\r\n"
	                + "      border-bottom: 1px solid #ddd;\r\n"
	                + "    }\r\n"
	                + "    tr:nth-child(even) {\r\n"
	                + "      background: #f9f9f9;\r\n"
	                + "    }\r\n"
	                + "    tr:hover {\r\n"
	                + "      background: #f1f1f1;\r\n"
	                + "    }\r\n"
	                + "    button {\r\n"
	                + "      padding: 10px 15px;\r\n"
	                + "      border: none;\r\n"
	                + "      border-radius: 5px;\r\n"
	                + "      cursor: pointer;\r\n"
	                + "      font-size: 14px;\r\n"
	                + "      transition: transform 0.2s, background-color 0.3s;\r\n"
	                + "    }\r\n"
	                + "    .update-btn {\r\n"
	                + "      background: #ff9800;\r\n"
	                + "      color: white;\r\n"
	                + "    }\r\n"
	                + "    .update-btn:hover {\r\n"
	                + "      background: #e68900;\r\n"
	                + "      transform: scale(1.05);\r\n"
	                + "    }\r\n"
	                + "    .delete-btn {\r\n"
	                + "      background: #f44336;\r\n"
	                + "      color: white;\r\n"
	                + "    }\r\n"
	                + "    .delete-btn:hover {\r\n"
	                + "      background: #d32f2f;\r\n"
	                + "      transform: scale(1.05);\r\n"
	                + "    }\r\n"
	                + "  </style>\r\n"
	                + "</head>\r\n"
	                + "<body>\r\n"
	                + "  <div class=\"container\">\r\n"
	                + "    <h1>Employee Details</h1>\r\n"
	                + "    <table>\r\n"
	                + "      <thead>\r\n"
	                + "        <tr>\r\n"
	                + "          <th>ID</th>\r\n"
	                + "          <th>Name</th>\r\n"
	                + "          <th>Age</th>\r\n"
	                + "          <th>Email</th>\r\n"
	                + "          <th>Salary</th>\r\n"
	                + "          <th>password</th>\r\n"
	                + "          <th>Actions</th>\r\n"
	                + "        </tr>\r\n"
	                + "      </thead>\r\n"
	                + "      <tbody>\r\n");

	        // Loop through the employee list and populate the table rows
	        for (Employee employee : e1) {
	            pr.write("<tr>\r\n"
	                    + "  <td>" + employee.getId() + "</td>\r\n"
	                    + "  <td>" + employee.getName() + "</td>\r\n"
	                    + "  <td>" + employee.getAge() + "</td>\r\n"
	                    + "  <td>" + employee.getEmail() + "</td>\r\n"
	                    + "  <td>" + employee.getSalary() + "</td>\r\n"
	                    + "  <td>" + employee.getpassword()+ "</td>\r\n"
	                    + "  <td>\r\n"
	                    + "   <a href=\"Update.html\" <button class=\"update-btn\">Update</button>\r\n"
	                    + "   <a href=\"Delete.html\" <button class=\"delete-btn\">Delete</button>\r\n"
	                    + "  </td>\r\n"
	                    + "</tr>\r\n");
	        }

	        // End of the HTML content
	        pr.write("      </tbody>\r\n"
	                + "    </table>\r\n"
	                + "  </div>\r\n"
	                + "</body>\r\n"
	                + "</html>");
	    }
	}