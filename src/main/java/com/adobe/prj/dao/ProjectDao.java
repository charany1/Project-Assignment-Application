/**
 * 
 */
package com.adobe.prj.dao;

import java.util.List;

import com.adobe.prj.entity.Project;

/**
 * @author rahujai
 * @author danchara
 *
 */
public interface ProjectDao {
	public int addProject(Project project) throws PersistenceException;
	
	public List<Project> getProjectsWithoutManager() throws FetchException;
	
	public int updateProjectHasManager(int projectId)throws PersistenceException;
	
	public List<Project> getAllProjects() throws FetchException;
	
	public int getNumberOfProject() throws FetchException;
}
