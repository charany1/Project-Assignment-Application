package com.adobe.prj.dao;

import java.util.List;

import com.adobe.prj.entity.Employee;

public interface EmployeeDao {
	public int addEmployee(Employee employee) throws PersistenceException;

	/*
	public List<Employee> getExistingProjectManagers();

	public Employee getEmployee(int pm_id);

	public List<Employee> getExistingEmployees();

	public List<Employee> getEmployeesOfProject(int id);
	*/
}
