/**
 * 
 */
package com.adobe.prj.client.service;

import com.adobe.prj.client.ui.AddProjectUi;
import com.adobe.prj.dao.PersistenceException;
import com.adobe.prj.dao.ProjectDao;
import com.adobe.prj.dao.jdbc.ProjectDaoJdbcImpl;
import com.adobe.prj.entity.Project;

/**
 * @author danchara
 *	
 *	Combines task of getting Project details from console and adding it to database . 
 *  Uses AddProjectUi and ProjectDaoJdbcImpl .
 */
public class AddProjectService {
	
	public static void getAndAddProject(){
		
		Project project = AddProjectUi.getProjectDetailsFromConsole();
		
		ProjectDao projectDao = new ProjectDaoJdbcImpl();
		
		int numRowsEffected;
		try {
			numRowsEffected = projectDao.addProject(project);
			if(numRowsEffected == 1){
				System.out.println("Project "+project.getName()+" added succesfully.");
			}
		} catch (PersistenceException e) {
			e.printStackTrace();
		}
		
	}

}
