package com.first.Service;

import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.first.Entity.Employee;

public class EmpService {
	
	static String url="jdbc:mysql://localhost:3306/jdbcsql1?user=root&password=root";
	static Connection con=null;
	static
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url);
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int saveEmp(Employee emp)
	{
		int no=0;
		String sql="insert into employee values(?,?,?,?,?,?)";
		try {
			PreparedStatement pstm=  con.prepareStatement(sql);
			pstm.setInt(1, emp.getId());
			pstm.setString(2,emp.getName() );
			pstm.setInt(3,emp.getAge());
			pstm.setString(4, emp.getEmail());
			pstm.setDouble(5,emp.getSalary());
			pstm.setString(6, emp.getpassword());
			no=pstm.executeUpdate();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return no;
	}
	public List<Employee>getAll()
	{
	 List<Employee>l1=new ArrayList<Employee>();
	String sql="select * from employee";
	try {
		Statement stm=con.createStatement();
		ResultSet rs=stm.executeQuery(sql);
		while(rs.next()) {
			int id=rs.getInt(1);
			String name=rs.getString(2);
			int age=rs.getInt(3);
			String email=rs.getString(4);
			double salary=rs.getDouble(5);
			String password=rs.getString(6);
			l1.add(new Employee(id,name,age,email,salary,password));
			
		}
		
	}catch(SQLException e) {
		e.printStackTrace();
	
	}
	return l1;
			

}
	public static int update(Employee e1) {
		   String query="UPDATE employee set Empname=?,age=?,Email=?,Salary=?,Password=? where id=?";
		   int no1=0;
		   try {
			PreparedStatement pstm=con.prepareStatement(query);
			
			pstm.setString(1,e1.getName());
			pstm.setInt(2,e1. getAge());
			pstm.setString(3,e1.getEmail());
			pstm.setDouble(4,e1.getSalary());
			pstm.setString(5,e1.getpassword());
			pstm.setInt(6,e1.getId());
		
			no1=pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return no1;
}
	public int delete(int id) {
		   String query2="delete from employee where id = ?";
		   int no2=0;
		   try {
			PreparedStatement pstm=con.prepareStatement(query2);
			pstm.setInt(1,id);
			no2=pstm.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return no2;
		   
	   }
	}
	                                    

