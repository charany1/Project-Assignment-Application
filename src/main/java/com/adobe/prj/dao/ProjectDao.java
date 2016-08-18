/**
 * 
 */
package com.adobe.prj.dao;

import java.util.List;

import com.adobe.prj.entity.Project;

/**
 * @author rahujai
 *
 */
public interface ProjectDao {
	public int addProject(Project project) throws PersistenceException;
	public List<Project> getExistingProjectsWithoutManager() throws FetchException;
//	public List<Project> getAllProjects();
}
