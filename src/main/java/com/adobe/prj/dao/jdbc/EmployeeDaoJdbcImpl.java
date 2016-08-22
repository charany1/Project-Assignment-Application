package com.adobe.prj.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.adobe.prj.dao.EmployeeDao;
import com.adobe.prj.dao.FetchException;
import com.adobe.prj.dao.PersistenceException;
import com.adobe.prj.entity.Employee;

/*
 * @author danchara
 * 
 *  Contains methods for CRUD operations on employee table in database.
 */

@Repository("employeeDao")
public class EmployeeDaoJdbcImpl implements EmployeeDao {

	
	
	/*
	 * /(non-Javadoc)
	 * @see com.adobe.prj.dao.EmployeeDao#addEmployee(com.adobe.prj.entity.Employee)
	 * Add an employee to database .
	 * @param employee new employee that is to be added
	 * @return number of rows effected in operation , 1 means successful addition of employee ,otherwise failure 
	 * @throws PersistenceException 
	 */
	public int addEmployee(Employee employee) throws PersistenceException {
			
		int numRowsEffected = -1;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		
		try {
			connection = DBUtil.getConnection();
			
			String addEmployeeSql = "INSERT INTO employee (name,email,role) VALUES (?,?,?);";
			
			preparedStatement = connection.prepareStatement(addEmployeeSql);
			
			preparedStatement.setString(1, employee.getName());
			preparedStatement.setString(2, employee.getEmail());
			preparedStatement.setInt(3,employee.getRole().ordinal());
			
			numRowsEffected = preparedStatement.executeUpdate();
			
			return numRowsEffected;
			
			
		} catch (SQLException e) {
			throw new PersistenceException("Unable to add employee.",e);
		
		}finally {
			DBUtil.releaseStatement(preparedStatement);
			DBUtil.releaseConnection(connection);
		}
	}
	
	
	
	/*
	 * /(non-Javadoc)
	 * @see com.adobe.prj.dao.EmployeeDao#getProjectManagers()
	 * 
	 * Get employees who are project managers from employee table .
	 * @return list of managers
	 * @throws FetchException
	 */
	public List<Employee> getProjectManagers() throws FetchException {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		List<Employee> projectManagers = new ArrayList<Employee>();
		
		
		
		try {
			connection = DBUtil.getConnection();
			String getProjectManagerSql = "SELECT id, name,email,role FROM employee WHERE role=1;";
			preparedStatement = connection.prepareStatement(getProjectManagerSql);
			ResultSet resultSet = preparedStatement.executeQuery(getProjectManagerSql);
			
			Employee employee ;
			
			int employeeId;
			String employeeName;
			String employeeEmail;
			int employeeRole;
			
			while(resultSet.next()){
				employeeId = resultSet.getInt(1);
				employeeName = resultSet.getString(2);
				employeeEmail = resultSet.getString(3);
				employeeRole = resultSet.getInt(4);
				
				employee = new Employee(employeeId,employeeName,employeeEmail,employeeRole);
				
				projectManagers.add(employee);
			}
			
		} catch (SQLException e) {
			throw new FetchException("Unable to fetch managers.",e);
		}finally{
			DBUtil.releaseStatement(preparedStatement);
			DBUtil.releaseConnection(connection);
		}
		
		return projectManagers;
		
	}

	
	/*
	 * (non-Javadoc)
	 * @see com.adobe.prj.dao.EmployeeDao#getStaffEmployees()
	 */

	public List<Employee> getStaffEmployees() throws FetchException {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		List<Employee> staffList = new ArrayList<Employee>();
		
		
		try {
			connection = DBUtil.getConnection();
			
			String getStaffEmployeesSql = "SELECT id, name,email,role FROM employee WHERE role=0;";
			
			preparedStatement = connection.prepareStatement(getStaffEmployeesSql);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			
			Employee employee ;
			
			int employeeId;
			String employeeName;
			String employeeEmail;
			int employeeRole;
			while(resultSet.next()){
				employeeId = resultSet.getInt(1);
				employeeName = resultSet.getString(2);
				employeeEmail = resultSet.getString(3);
				employeeRole = resultSet.getInt(4);
				
				employee = new Employee(employeeId,employeeName,employeeEmail,employeeRole);
				
				staffList.add(employee);
			}
		} catch (SQLException e) {
			throw new FetchException("Unable to fetch staff employee list.",e);
		}finally{
			DBUtil.releaseStatement(preparedStatement);
			DBUtil.releaseConnection(connection);
		}
				
		
		return staffList;
	}
	
	
	public List<Employee> getAllEmployees() throws FetchException {
		
		Connection connection = null;
		Statement statement = null;
		
		List<Employee> AllList = new ArrayList<Employee>();
		
		try {
			
			connection = DBUtil.getConnection();
			statement = connection.createStatement();
			
			String getAllEmployeesSql = "SELECT id,name,email,role FROM employee;";
			
			ResultSet resultSet = statement.executeQuery(getAllEmployeesSql);
			
			Employee employee ;
			int employeeId;
			String employeeName;
			String employeeEmail;
			int employeeRole;
			
			while(resultSet.next()){
				employeeId = resultSet.getInt(1);
				employeeName = resultSet.getString(2);
				employeeEmail = resultSet.getString(3);
				employeeRole = resultSet.getInt(4);
				
				employee = new Employee(employeeId,employeeName,employeeEmail,employeeRole);
				
				AllList.add(employee);
			}
		} catch (SQLException e) {
			throw new FetchException("Unable to fetch staff employee list.",e);
		}finally{
			DBUtil.releaseStatement(statement);
			DBUtil.releaseConnection(connection);
		}
		
		return AllList;
	}
}
