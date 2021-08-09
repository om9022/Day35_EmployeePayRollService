package com.bridgelabz.employeepayrolltest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.bridgelabz.employeepayrollservice.EmployeeData;
import com.bridgelabz.employeepayrollservice.EmployeePayrollService;

public class EmployeePayrollTest 
{
	@Test
	public void given3Employees_WhenWrittenToFile_ShouldMatchEmployeeEntries() 
	{
		EmployeePayrollService employeePayrollService = new EmployeePayrollService();
		employeePayrollService.addEmployee(new EmployeeData(1,"Jeff Bezos",10000));
		employeePayrollService.addEmployee(new EmployeeData(2,"Bill Gates",20000));
		employeePayrollService.addEmployee(new EmployeeData(3,"Mark Z",30000));
		employeePayrollService.writeEmployeeDataToFile();
		assertEquals(3,employeePayrollService.countEntries());
	}

	@Test
	public void given3Employees_WhenWrittenToFile_ShouldPrintEmployeeEntries() 
	{
		EmployeePayrollService employeePayrollService = new EmployeePayrollService();
		employeePayrollService.addEmployee(new EmployeeData(1,"Jeff Bezos",10000));
		employeePayrollService.addEmployee(new EmployeeData(2,"Bill Gates",20000));
		employeePayrollService.addEmployee(new EmployeeData(3,"Mark Z",30000));
		employeePayrollService.writeEmployeeDataToFile();
		employeePayrollService.printData();
		assertEquals(3, employeePayrollService.countEntries());
	}

	@Test
	public void given3Employees_WhenWrittenToFile_ShouldPrintNumberOfEmployeeEntries() 
	{
		EmployeePayrollService employeePayrollService = new EmployeePayrollService();
		employeePayrollService.addEmployee(new EmployeeData(1,"Jeff Bezos",10000));
		employeePayrollService.addEmployee(new EmployeeData(2,"Bill Gates",20000));
		employeePayrollService.addEmployee(new EmployeeData(3,"Mark Z",30000));
		employeePayrollService.writeEmployeeDataToFile();
		assertEquals(3, employeePayrollService.countEntries());
	}

	@Test
	public void givenFile_WhenReadingFromFile_ShouldMatchEmployeeCount() 
	{
		EmployeePayrollService employeePayrollService = new EmployeePayrollService();
		assertEquals(3, employeePayrollService.countEntries());
	}
	
	@Test
	public void givenEmployeePayrollInDB_WhenRetrived_ShouldMatchEmployeeCount()
	{
		EmployeePayrollService employeePayrollService = new EmployeePayrollService();
		 List<EmployeeData> employeeList = employeePayrollService.readEmployeePayrollFromDB();
		assertEquals(4, employeeList.size());
	}
	
	@Test
	public void givenEmployeePayrollDB_WhenTeresaSalaryUpdated_ShouldUpdateSalary()
	{
		EmployeePayrollService employeePayrollService = new EmployeePayrollService();
		int rowsChanged  = employeePayrollService.updateSalaryInDB("Teresa",3000000);
		assertEquals(1, rowsChanged);
	}

	@Test
	public void givenEmployeePayrollDB_WhenTeresaSalaryUpdated_ShouldSyncWithDatabase()
	{
		EmployeePayrollService employeePayrollService = new EmployeePayrollService();
		employeePayrollService.readEmployeePayrollFromDB();
		employeePayrollService.updateSalaryInDB("Teresa",3000000);
		boolean result = employeePayrollService.checkSyncWithDB("Teresa");
		assertTrue(result);
	}
	
	@Test
	public void givenEmployeePayrollDB_WhenGivendate_ShouldRetunListOfEmployees()
	{
		EmployeePayrollService employeePayrollService = new EmployeePayrollService();
		List<EmployeeData> employeeList = employeePayrollService.employeeJoinedAfterDate("2019-01-01");
		assertEquals(2, employeeList.size());
	}

	@Test
	public void givenoFindSumOfAllEmployee_WhenFemale_ShouldRetunSumOFSalaryOfEmployees()
	{
		EmployeePayrollService employeePayrollService = new EmployeePayrollService();
		double result = employeePayrollService.calculateOfSalaryByGender("sum",'F');
		assertEquals(3000000.00, result,0.00);
	}

	@Test
	public void givenoFindSumOfAllEmployee_WhenMale_ShouldRetunSumOFSalaryOfEmployees()
	{
		EmployeePayrollService employeePayrollService = new EmployeePayrollService();
		double result = employeePayrollService.calculateOfSalaryByGender("sum",'M');
		assertEquals(90000.00, result,0.00);
	}

	@Test
	public void givenoFindAvgOfAllEmployee_WhenFemale_ShouldRetunAvgOFSalaryOfEmployees()
	{
		EmployeePayrollService employeePayrollService = new EmployeePayrollService();
		double result = employeePayrollService.calculateOfSalaryByGender("avg",'F');
		assertEquals(3000000.00, result,0.00);
	}
	
	@Test
	public void givenoFindAvgOfAllEmployee_WhenMale_ShouldRetunAvgOfEmployees()
	{
		EmployeePayrollService employeePayrollService = new EmployeePayrollService();
		double result = employeePayrollService.calculateOfSalaryByGender("avg",'M');
		assertEquals(30000, result,0.00);
	}

	
	@Test
	public void givenoFindMinOfAllEmployee_WhenFemale_ShouldRetunMinOFSalaryOfEmployees()
	{
		EmployeePayrollService employeePayrollService = new EmployeePayrollService();
		double result = employeePayrollService.calculateOfSalaryByGender("min",'F');
		assertEquals(3000000.00, result,0.00);
	}
	
	@Test
	public void givenoFindMinOfAllEmployee_WhenMale_ShouldRetunMinOfEmployees()
	{
		EmployeePayrollService employeePayrollService = new EmployeePayrollService();
		double result = employeePayrollService.calculateOfSalaryByGender("min",'M');
		assertEquals(10000, result,0.00);
	}

	@Test
	public void givenoFindMaxOfAllEmployee_WhenFemale_ShouldRetunMaxOFSalaryOfEmployees()
	{
		EmployeePayrollService employeePayrollService = new EmployeePayrollService();
		double result = employeePayrollService.calculateOfSalaryByGender("max",'F');
		assertEquals(3000000.00, result,0.00);
	}
	
	@Test
	public void givenoFindMinOfAllEmployee_WhenMale_ShouldRetunMaxOfEmployees()
	{
		EmployeePayrollService employeePayrollService = new EmployeePayrollService();
		double result = employeePayrollService.calculateOfSalaryByGender("max",'M');
		assertEquals(40000, result,0.00);
	}

	@Test
	public void givenoFindCountOfAllEmployee_WhenFemale_ShouldRetunCountOFSalaryOfEmployees()
	{
		EmployeePayrollService employeePayrollService = new EmployeePayrollService();
		double result = employeePayrollService.calculateOfSalaryByGender("count",'F');
		assertEquals(1, result,0.00);
	}
	
	@Test
	public void givenoFindCountOfAllEmployee_WhenMale_ShouldRetunCountOfEmployees()
	{
		EmployeePayrollService employeePayrollService = new EmployeePayrollService();
		double result = employeePayrollService.calculateOfSalaryByGender("count",'M');
		assertEquals(3, result,0.00);
	}
	
	@Test
	public void givenEmployeeDetails_WhenInserted_ShouldSyncWithDatabase() 
	{
		EmployeePayrollService employeePayrollService = new EmployeePayrollService();
		employeePayrollService.readEmployeePayrollFromDB();
		List<String> department = new ArrayList<>();
		department.add("marketing");
		department.add("sales");
		employeePayrollService.addDataInDB("Mark",'M',40000,"2020-01-03",department);
		boolean result = employeePayrollService.checkSyncWithDB("Mark");
		assertTrue(result);
	}
	
	@Test
	public void givenEmployeeName_WhenDetele_ShouldDeletefromDB() 
	{
		EmployeePayrollService employeePayrollService = new EmployeePayrollService();
		employeePayrollService.readEmployeePayrollFromDB();
		employeePayrollService.deleteFromDB("Mark");
		List<EmployeeData> employeeList = employeePayrollService.readEmployeePayrollFromDB();
		assertEquals(3, employeeList.size());
	}
}
