package com.adobe.prj.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.adobe.prj.dao.EmployeeDao;
import com.adobe.prj.dao.PersistenceException;
import com.adobe.prj.entity.Employee;

/*
 * @author danchara
 * 
 *  Contains methods for CRUD operations on employee table in database.
 */

public class EmployeeDaoJdbcImpl implements EmployeeDao {

	
	
	
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
	@Override
	public List<Employee> getExistingProjectManagers() {
		String SQL = "SELECT id, first_name, last_name, email, p_id, is_pm FROM employees WHERE is_pm=true";
		List<Employee> result = new ArrayList<Employee>();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(SQL);
			
			
			while(rs.next()) {
				Employee e = new Employee(rs.getString("first_name"), rs.getString("last_name"), rs.getString("email"));
				e.setId(rs.getInt("id"));
				e.setP_id(rs.getInt("p_id"));
				e.setIs_pm(rs.getBoolean("is_pm"));
				result.add(e);
			}
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		return result;
	}

	@Override
	public Employee getEmployee(int pm_id) {
		Employee emp = null;
		String SQL = "SELECT id, first_name, last_name, email, p_id, is_pm FROM employees WHERE id=?";
		try {
			PreparedStatement ps = con.prepareStatement(SQL);
			ps.setInt(1, pm_id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			emp = new Employee(rs.getString("first_name"), rs.getString("last_name"), rs.getString("email"));
			emp.setId(rs.getInt("id"));
			emp.setIs_pm(rs.getBoolean("is_pm"));
			emp.setP_id(rs.getInt("p_id"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return emp;
	}

	@Override
	public List<Employee> getExistingEmployees() {
		List<Employee> emps = new ArrayList<Employee>();
		String SQL = "SELECT id, first_name, last_name, email, p_id, is_pm FROM employees WHERE is_pm=?";
		try {
			PreparedStatement ps = con.prepareStatement(SQL);
			ps.setBoolean(1, false);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Employee emp = new Employee(rs.getString("first_name"), rs.getString("last_name"), rs.getString("email"));
				emp.setId(rs.getInt("id"));
				emp.setIs_pm(rs.getBoolean("is_pm"));
				emp.setP_id(rs.getInt("p_id"));
				emps.add(emp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return emps;
	}

	@Override
	public List<Employee> getEmployeesOfProject(int id) {
		List<Employee> emps = new ArrayList<Employee>();
		String SQL = "SELECT id, first_name, last_name, email, p_id, is_pm FROM employees WHERE p_id=?";
		try {
			PreparedStatement ps = con.prepareStatement(SQL);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Employee emp = new Employee(rs.getString("first_name"), rs.getString("last_name"), rs.getString("email"));
				emp.setId(rs.getInt("id"));
				emp.setIs_pm(rs.getBoolean("is_pm"));
				emp.setP_id(rs.getInt("p_id"));
				emps.add(emp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return emps;
	}
	*/

}
