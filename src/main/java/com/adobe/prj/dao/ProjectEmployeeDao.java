/**
 * 
 */
package com.adobe.prj.dao;

import java.util.List;

import com.adobe.prj.dto.ProjectDetailsDto;

/**
 * @author danchara
 * Declares methods for CRUD operations on project_employee table.
 */
public interface ProjectEmployeeDao {
	
	/*
	 * Adds new project-manager assignment . Implementation must update has_project_manager 
	 * field of concerned project in project table to be true ,else inconsistency will creep in.
	 * 
	 * @param projectId id of project which is being assigned a manager
	 * @param managerId employee if of manager 
	 * 
	 * @return number of rows effected : 1 means successful operation , anything else
	 * indicate failure
	 * @throws PersistenceException
	 * 
	 */
	public int addProjectManagerAssignemnt(int projectId, int managerId) throws PersistenceException;
	
	/*
	 * Adds new project-staff assignment . 
	 * 
	 * @param projectId id of project which is assigned a staff .
	 * @param staffId employee id of staff member
	 * 
	 * @return number of rows effected :1 means successful operation , anything else
	 * indicate failure
	 * 
	 * @throws PersistenceException
	 */
	public int addProjectStaffAssignment(int projectId, int staffId) throws PersistenceException;
	
	/*
	 * For getting all details for a project for listing as per requirement (e).
	 * 
	 * @param projectId id of project for which details are fetched
	 * 
	 * @return ProjectDetailsDto : contains info such as project name ,manager , staff members .
	 * 
	 * @throws FetchException
	 */
	public ProjectDetailsDto getProjectDetailForListing(int projectId) throws FetchException;
	
	
	/*
	 * For fetching list of ProjectDetailsDto(s) . Internally calls getProjectDetailForListing(int projectId) to get Dto(s) for
	 * individual projects and forming a list .
	 * 
	 * @return list of ProjectDetailsDto
	 * @throws FetchException
	 */
	public List<ProjectDetailsDto> getAllProjectsDetailsForListing() throws FetchException;

}
