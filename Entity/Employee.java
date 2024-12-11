package com.first.Entity;

public class Employee {
	private int id;
	private String name;
	private int age;
	private String email;
	private double salary;
	private String password;
	public Employee(int id, String name, int age, String email, double salary,String password) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.email = email;
		this.salary = salary;
		this.password=password;
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getpassword() {
		return password;
	}
	public void setpassword(String password) {
		this.password = password;
	}
	

}
