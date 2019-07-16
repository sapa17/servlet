package com.vtalent.hrm.dao;


import java.sql.*;
import java.util.*;

import com.vtalent.hrm.beans.Employee;


public class DBOperations {
	Connection connection;
	Statement statement;
	PreparedStatement pstatement;
	ResultSet rset;

	public DBOperations() {
		connection = MySqlConnection.getInstance();
	}

	public int InsertDataWithStatement(Employee employee) {
		String query = "insert into employee values(?,?,?,?,?)";
		int result = 0;
		try {
			pstatement = connection.prepareStatement(query);
			pstatement.setInt(1, employee.getEmployeeID());
			pstatement.setString(2, employee.getEmployeeName());
			pstatement.setDouble(3, employee.getEmployeeSalary());
			pstatement.setString(4, employee.getEmpolyeeMobile());
			pstatement.setString(5, employee.getEmployeeAddress());
			
			 result = pstatement.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		}
		return result;
	}

	public int DeleteDataWithStatement(int empID) {
		String deletequery = "delete from employee_table where empID=?";
		int result = 0;
		try {
			pstatement = connection.prepareStatement(deletequery);
			 pstatement.setInt(1, empID);
			int result2 = pstatement.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		return result;
	}

	public List<Employee> Search(int employeeID) {
		String query = "select employeeName , employeeSalary , employeeMobile,employeeAddress from employee where employeeID=?";
		Employee employee = null;
		List<Employee> listofemployee = new ArrayList<>();
		try {
			pstatement = connection.prepareStatement(query);
			pstatement.setInt(1, employeeID);
			rset = pstatement.executeQuery();
			while (rset.next()) {
				employee = new Employee();
				employee.setEmployeeID(employeeID);
				employee.setEmployeeName(rset.getString(1));
				employee.setEmployeeSalary(rset.getDouble(2));
				employee.setEmpolyeeMobile(rset.getString(3));
				employee.setEmployeeAddress(rset.getString(4));
				listofemployee.add(employee);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return listofemployee;
	}
	public Employee	SearchByID(int employeeID) {
		String query = "select employeeName , employeeSalary , employeeMobile,employeeAddress from employee where employeeID=?";
		Employee employee = new Employee();
		try {
			pstatement = connection.prepareStatement(query);
			pstatement.setInt(1, employeeID);
			rset = pstatement.executeQuery();
			while (rset.next()) {
				employee = new Employee();
				employee.setEmployeeID(employeeID);
				employee.setEmployeeName(rset.getString(1));
				employee.setEmployeeSalary(rset.getDouble(2));
				employee.setEmpolyeeMobile(rset.getString(3));
				employee.setEmployeeAddress(rset.getString(4));
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		return employee;

		
	}
	
	public List<Employee> Print(){
		String query = "select * from employee";
		Employee employee = null;
		List<Employee> listofemployees = new ArrayList<>();
		try {
			pstatement = connection.prepareStatement(query);
			rset = pstatement.executeQuery();
			while(rset.next()) {
				employee = new Employee();
				employee.setEmployeeID(rset.getInt(1));
				employee.setEmployeeName(rset.getString(2));
				employee.setEmployeeSalary(rset.getDouble(3));
				employee.setEmpolyeeMobile(rset.getString(4));
				employee.setEmployeeAddress(rset.getString(5));
				listofemployees.add(employee);
			}
		} catch (SQLException e) {
			 e.printStackTrace();
		}
		return listofemployees;

	}
	
	public Employee updateEmployee(Employee emp) {
		String query = "update employee_table set empName=?, empPackage=? , empSalary=?, empMobile=?  where empID=? ";

     		  try { 
			pstatement = connection.prepareStatement(query);
			pstatement.setString(1, emp.getEmployeeName());
			pstatement.setDouble(2, emp.getEmployeePackage());
			pstatement.setDouble(3, emp.getEmployeeSalary());
			pstatement.setString(4, emp.getEmpolyeeMobile());
			pstatement.setInt(5, emp.getEmployeeID());

			int result1 = pstatement.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		}
		return emp;
	}
}

