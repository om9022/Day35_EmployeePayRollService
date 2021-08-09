package com.bridgelabz.employeepayrolltest;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;



public class TestingDatabaseConnectivty
{
	public static void main(String[] args) 
	{
		String jdbcURL = "jdbc:mysql://localhost:3306/payroll_service?useSSL=false";
		String username = "root";
		String password = "OmChikane@9022";
		Connection connection;
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver loaded");
		}
		catch (Exception e) 
		{
			throw new IllegalStateException("Cannot find the Driver",e);
		}
		
		listDriver();
		
		
		try 
		{
			System.out.println("Conecting to database"+jdbcURL);
			connection =  DriverManager.getConnection(jdbcURL,username,password);
			System.out.println("Connection sucessful" + connection);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	private static void listDriver() 
	{
		Enumeration<Driver> driverlist = DriverManager.getDrivers();
		while (driverlist.hasMoreElements()) 
		{
			Driver driver = (Driver) driverlist.nextElement();
			System.out.println("  "+driver.getClass().getName());
		}
	}
}
