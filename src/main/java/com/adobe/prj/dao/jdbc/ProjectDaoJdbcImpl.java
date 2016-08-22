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

import org.springframework.stereotype.Repository;

import com.adobe.prj.dao.FetchException;
import com.adobe.prj.dao.PersistenceException;
import com.adobe.prj.dao.ProjectDao;
import com.adobe.prj.entity.Project;

/**
 * @author rahujai
 * @author danchara
 * 
 * For CRUD operations on project table in database.
 *
 */

@Repository("projectDao")
public class ProjectDaoJdbcImpl implements ProjectDao {
	
	/*
	 * /(non-Javadoc)
	 * @see com.adobe.prj.dao.ProjectDao#addProject(com.adobe.prj.entity.Project)
	 * Add a new project to database .
	 * @param project New project that is to be added .
	 * @return number of rows effected in operation , 1 means successful addition of employee ,otherwise failure 
	 * @throws PersistenceException
	 */
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
			
			
			
			
		} catch (SQLException e) {
			throw new PersistenceException("Unable to add project.",e);
		
		}finally {
			DBUtil.releaseStatement(preparedStatement);
			DBUtil.releaseConnection(connection);
		}
		return numRowsEffected;
	}
	
	
	/*
	 * /(non-Javadoc)
	 * @see com.adobe.prj.dao.ProjectDao#getProjectsWithoutManager()
	 * Get projects which don't already have managers
	 * @return List of projects without managers.
	 * @throws FetchException
	 */
	public List<Project> getProjectsWithoutManager() throws FetchException {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		List<Project> projectsWithoutManager = new ArrayList<Project>();
		
		
		
		try {
			connection = DBUtil.getConnection();
			String fetchProjectsWithoutManagerSql = "SELECT id, name,has_project_manager FROM project WHERE "
					+ "has_project_manager = false;";
			
			preparedStatement = connection.prepareStatement(fetchProjectsWithoutManagerSql);
			
			ResultSet resultSet = preparedStatement.executeQuery(fetchProjectsWithoutManagerSql);
			
			Project project;
			int projectId;
			String projectName;
			boolean hasProjectManager;
			
			while(resultSet.next()){
				projectId = resultSet.getInt(1);
				projectName = resultSet.getString(2);
				hasProjectManager = resultSet.getBoolean(3);
				
				project = new Project(projectId,projectName,hasProjectManager);
				
				projectsWithoutManager.add(project);				
			}
			
			
		} catch (SQLException e) {
			throw new FetchException("Couldn't fetch projects without manager.",e);
		}finally{
			DBUtil.releaseStatement(preparedStatement);
			DBUtil.releaseConnection(connection);
		}
		
		return projectsWithoutManager;
	}

	/*
	 * /(non-Javadoc)
	 * @see com.adobe.prj.dao.ProjectDao#updateProjectHasManager(int)
	 * Updates has_project_manager to true . Called from ProjectEmployeeDao#addProjectManagerAssignemnt .
	 * 
	 * @param projectId id of project whose has_project_manager column is to be set
	 * @return number of rows effected in update operation : 1 mean successful operation ,anything else 
	 * indicates failure
	 * 
	 * @throws PersistenceException
	 */
	public int updateProjectHasManager(int projectId) throws PersistenceException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		int numRowsEffected;
		
		String updateProjectHasManagerSql = "UPDATE project SET has_project_manager = true WHERE id = ?;";
		
		try {
			connection = DBUtil.getConnection();
			preparedStatement = connection.prepareStatement(updateProjectHasManagerSql);
			preparedStatement.setInt(1, projectId);
			numRowsEffected = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			throw new PersistenceException("Unable to update project's has_project_manager status to true.",e);
		}finally {
			DBUtil.releaseStatement(preparedStatement);
			DBUtil.releaseConnection(connection);
		}
		return numRowsEffected;
		
				
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see com.adobe.prj.dao.ProjectDao#getAllProjects()
	 * 
	 *  
	 */

	public List<Project> getAllProjects() throws FetchException {
		
		Connection connection = null;
		Statement statement = null;
		
		List<Project>projectList = new ArrayList<Project>();

		
		
		try {
			connection = DBUtil.getConnection();
			statement = connection.createStatement();
			String getAllProjectsSql = "SELECT id, name,has_project_manager FROM project;";
			
			ResultSet resultSet = statement.executeQuery(getAllProjectsSql);
			
			Project project;
			int projectId;
			String projectName;
			boolean hasProjectManager;
			
			while(resultSet.next()){
				projectId = resultSet.getInt(1);
				projectName = resultSet.getString(2);
				hasProjectManager = resultSet.getBoolean(3);
				
				project = new Project(projectId,projectName,hasProjectManager);
				
				projectList.add(project);
				
			}
			
			
			
		} catch (SQLException e) {
			throw new FetchException("Unable to fetch all projects.",e);
		}finally {
			DBUtil.releaseStatement(statement);
			DBUtil.releaseConnection(connection);
		}
		
		
		
		return projectList;
	}


	public int getNumberOfProject() throws FetchException {
		Connection connection = null;
		Statement statement = null;
		
		int numberOfProjects = 0;
		
		try {
			connection = DBUtil.getConnection();
			statement = connection.createStatement();
			
			String getNumberOfProjectSql = "SELECT max(id) FROM project;";
			
			ResultSet resultSet = statement.executeQuery(getNumberOfProjectSql);
			while(resultSet.next()){
			numberOfProjects = resultSet.getInt(1);
			System.out.println("Number of projects : "+numberOfProjects);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new FetchException("Unable to get total number of projects.",e);
		
		}finally {
			DBUtil.releaseStatement(statement);
			DBUtil.releaseConnection(connection);
		}
		
		
		
		
		return numberOfProjects;
	}

	
}
