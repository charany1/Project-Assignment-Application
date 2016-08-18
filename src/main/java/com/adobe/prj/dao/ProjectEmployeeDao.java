/**
 * 
 */
package com.adobe.prj.dao;

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

}
