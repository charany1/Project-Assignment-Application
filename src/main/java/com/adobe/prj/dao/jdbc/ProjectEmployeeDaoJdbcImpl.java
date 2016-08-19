/**
 * 
 */
package com.adobe.prj.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.adobe.prj.dao.PersistenceException;
import com.adobe.prj.dao.ProjectDao;
import com.adobe.prj.dao.ProjectEmployeeDao;

/**
 * @author danchara
 *
 */
public class ProjectEmployeeDaoJdbcImpl implements ProjectEmployeeDao {

	/* (non-Javadoc)
	 * @see com.adobe.prj.dao.ProjectEmployeeDao#addProjectManagerAssignemnt(int, int)
	 * 
	 * Adds new project-manager assignment . Implementation must update has_project_manager 
	 * field of concerned project in project table to be true ,else inconsistency will creep in.
	 * 
	 * @param projectId id of project which is being assigned a manager
	 * @param managerId employee if of manager 
	 * 
	 * @return number of rows effected : 1 means successful operation , anything else
	 * indicate failure
	 * @throws PersistenceException
	 */
	public int addProjectManagerAssignemnt(int projectId, int managerId) throws PersistenceException {
		
		Connection connection = null ;
		PreparedStatement preparedStatement = null ;
		
		int numRowsEffected;
		
		
		
		try {
			connection = DBUtil.getConnection();
			String addProjectManagerAssignmentSql = "INSERT INTO project_employee(project_id,employee_id)"
					+ " VALUES(?,?);";
			preparedStatement = connection.prepareStatement(addProjectManagerAssignmentSql);
			
			preparedStatement.setInt(1, projectId);
			preparedStatement.setInt(2, managerId);
			
			numRowsEffected = preparedStatement.executeUpdate();
			
			
			
			//update has_project_manager to true in project table
			ProjectDao projectDao = new ProjectDaoJdbcImpl();
			projectDao.updateProjectHasManager(projectId);
			
			
		} catch (SQLException e) {
			throw new PersistenceException("Unable to assign manager to project.",e);
		}
		
		
		return numRowsEffected;
	}

	
	/*
	 * (non-Javadoc)
	 * @see com.adobe.prj.dao.ProjectEmployeeDao#addProjectStaffAssignment(int, int)
	 */
	public int addProjectStaffAssignment(int projectId, int staffId) throws PersistenceException {
		
		Connection connection = null ;
		PreparedStatement preparedStatement = null ;
		
		int numRowsEffected;
		
		try {
			connection = DBUtil.getConnection();
			String addProjectManagerAssignmentSql = "INSERT INTO project_employee(project_id,employee_id)"
					+ " VALUES(?,?);";
			preparedStatement = connection.prepareStatement(addProjectManagerAssignmentSql);
			
			preparedStatement.setInt(1, projectId);
			preparedStatement.setInt(2, staffId);
			
			numRowsEffected = preparedStatement.executeUpdate();
			
			
			
			
		} catch (SQLException e) {
			throw new PersistenceException("Unable to assign staff to project.",e);
		}
		
		
		return numRowsEffected;
		
		
		
	}

}
