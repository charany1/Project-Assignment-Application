/**
 * 
 */
package com.adobe.prj.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.adobe.prj.dao.PersistenceException;
import com.adobe.prj.dao.ProjectDao;
import com.adobe.prj.entity.Project;

/**
 * @author rahujai
 * 
 * For CRUD operations on project table in database.
 *
 */
public class ProjectDaoJdbcImpl implements ProjectDao {
	
	
	public int addProject(Project project) throws PersistenceException{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		int numRowsEffected = -1;
		
		try {
			connection = DBUtil.getConnection();
			
			String addProjectSql = "INSERT INTO project (name) VALUES (?);";
			
			preparedStatement = connection.prepareStatement(addProjectSql);
			
			
			
			
			preparedStatement.setString(1, project.getName());
			
			numRowsEffected = preparedStatement.executeUpdate();
			
			return numRowsEffected;
			
			
		} catch (SQLException e) {
			throw new PersistenceException("Unable to add project.",e);
		
		}finally {
			DBUtil.releaseStatement(preparedStatement);
			DBUtil.releaseConnection(connection);
		}
	}

	/*
	@Override
	public List<Project> getExistingProjects() {
		String SQL = "SELECT name FROM projects WHERE pm_id=-1";
		List<Project> result = new ArrayList<Project>();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(SQL);
			while(rs.next()) {
				Project p = new Project(rs.getString("name"));
				p.setId(rs.getInt("id"));
				p.setPm_id(rs.getInt("pm_id"));
				result.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<Project> getAllProjects() {
		String SQL = "SELECT name FROM projects";
		List<Project> result = new ArrayList<Project>();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(SQL);
			while(rs.next()) {
				Project p = new Project(rs.getString("name"));
				p.setId(rs.getInt("id"));
				p.setPm_id(rs.getInt("pm_id"));
				result.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	*/
}
