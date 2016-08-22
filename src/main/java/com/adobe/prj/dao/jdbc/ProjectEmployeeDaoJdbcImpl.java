/**
 * 
 */
package com.adobe.prj.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.adobe.prj.dao.FetchException;
import com.adobe.prj.dao.PersistenceException;
import com.adobe.prj.dao.ProjectDao;
import com.adobe.prj.dao.ProjectEmployeeDao;
import com.adobe.prj.dto.ProjectDetailsDto;

/**
 * @author danchara
 * @author anurjain
 *
 */
@Repository
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
		}finally {
			DBUtil.releaseStatement(preparedStatement);
			DBUtil.releaseConnection(connection);
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
		}finally {
			DBUtil.releaseStatement(preparedStatement);
			DBUtil.releaseConnection(connection);
		}
		
		
		return numRowsEffected;
		
		
		
	}

	/*
	 * (non-Javadoc)
	 * @see com.adobe.prj.dao.ProjectEmployeeDao#getProjectDetailForListing(int)
	 */
	public ProjectDetailsDto getProjectDetailForListing(int projectId) throws FetchException {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		ProjectDetailsDto projectDetailsDto;
		

		try {
			connection = DBUtil.getConnection();
			String getProjectDetailsDtoSql = "SELECT project_id,project_name,result.employee_id,employee.name AS employee_name,role "
					+ " FROM "
					+ " (SELECT project.id AS project_id,project.name AS project_name,employee_id FROM project "
					+ "LEFT JOIN "
					+ "project_employee "
					+ "ON project.id=project_employee.project_id)"
					+ " AS result "
					+ "LEFT JOIN "
					+ "employee ON employee.id = result.employee_id WHERE project_id = ?;";
			
			preparedStatement = connection.prepareStatement(getProjectDetailsDtoSql);
			
			preparedStatement.setInt(1, projectId);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			
			
			
			String projectName = null;
			String managerName = null;
			String employeeName = null;
			List<String> staff = new ArrayList<String>();
			int role ;
			
			
			
			while(resultSet.next()){
				
				if(projectName == null){
					projectName = resultSet.getString(2);
				}
				
				employeeName = resultSet.getString(4);
				
				
				//getting manager's name 
				
				role = resultSet.getInt(5);
				
				if(role == 1 && managerName == null){
					managerName = employeeName;
				}else if(employeeName != null){
					staff.add(employeeName);
				}
				
				
				
				
			}
			projectDetailsDto = new ProjectDetailsDto(projectId, projectName, managerName, staff);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new FetchException("Couldn't fetch ProjectDetailsDto",e);
		}finally {
			DBUtil.releaseStatement(preparedStatement);
			DBUtil.releaseConnection(connection);
		}
		
		
		
		
		return projectDetailsDto;
	}

	
	/*
	 * (non-Javadoc)
	 * @see com.adobe.prj.dao.ProjectEmployeeDao#getAllProjectsDetailsForListing()
	 */
	public List<ProjectDetailsDto> getAllProjectsDetailsForListing() throws FetchException {
		
		ProjectDao projectDao = new ProjectDaoJdbcImpl();
		
		int numberOfProjects = projectDao.getNumberOfProject();
		
		
		List<ProjectDetailsDto> projectDetailsDtoList = new ArrayList<ProjectDetailsDto>();
		
		for (int projectId = 1; projectId <= numberOfProjects; projectId++) {
			projectDetailsDtoList.add(getProjectDetailForListing(projectId));
			
		}
		
		
		return projectDetailsDtoList;
	}

}
