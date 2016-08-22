package com.adobe.prj.dao;

import java.util.List;

import com.adobe.prj.entity.Employee;

public interface EmployeeDao {
	public int addEmployee(Employee employee) throws PersistenceException;

	
	public List<Employee> getProjectManagers() throws FetchException;
	
	public List<Employee> getStaffEmployees() throws FetchException;
	
	public List<Employee> getAllEmployees() throws FetchException;
}
