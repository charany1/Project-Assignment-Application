/**
 * 
 */
package com.adobe.prj.client.service;

import java.util.ArrayList;
import java.util.List;

import com.adobe.prj.client.ui.AssignProjectManagerUi;
import com.adobe.prj.dao.EmployeeDao;
import com.adobe.prj.dao.FetchException;
import com.adobe.prj.dao.PersistenceException;
import com.adobe.prj.dao.ProjectDao;
import com.adobe.prj.dao.ProjectEmployeeDao;
import com.adobe.prj.dao.jdbc.EmployeeDaoJdbcImpl;
import com.adobe.prj.dao.jdbc.ProjectDaoJdbcImpl;
import com.adobe.prj.dao.jdbc.ProjectEmployeeDaoJdbcImpl;
import com.adobe.prj.entity.Employee;
import com.adobe.prj.entity.Project;

/**
 * @author danchara
 *	
 * For feature c) Assign a project manager to a project .
 * 
 * Service class that combines methods for : 
 * 1. Fetch existing projects(without manager) => ProjectDao#getProjectsWithoutManager
 * 2. Fetch managers => EmployeeDao#getProjectManagers
 * 3. Display projects on console => AssignProjectManagerUi#displayProjects
 * 4. Display managers on console => AssignProjectManagerUi#displayManagers
 * 5. Get project choice from console => AssignProjectManagerUi#getChosenProjectid
 * 6. Get manager choice from console => AssignProjectManagerUi#getChosenManagerId
 * 7. Update assignment in database => ProjectEmployeeDao#addProjectManagerAssignemnt
 * 	7.1 Update has_project_manager status in project table => ProjectDao#updateProjectHasManager
 * 
 */
public class AssignProjectManagerService {
	
	public static void assignManagerToProject(){
		
		int projectIdOfProjectChosen;
		int employeeIdOfManagerChosen;
		
		List<Employee> managerList = new ArrayList<Employee>();
		List<Project> projectsWithoutManagers = new ArrayList<Project>();
		
		ProjectDao projectDao = new ProjectDaoJdbcImpl();
		EmployeeDao employeeDao = new EmployeeDaoJdbcImpl();
		ProjectEmployeeDao projectEmployeeDao = new ProjectEmployeeDaoJdbcImpl();
		
		try {
			projectsWithoutManagers = projectDao.getProjectsWithoutManager();
		} catch (FetchException e) {
			
			e.printStackTrace();
		}
		try {
			managerList = employeeDao.getProjectManagers();
		} catch (FetchException e) {
			e.printStackTrace();
		}
		
		AssignProjectManagerUi assignProjectManagerUi = new AssignProjectManagerUi(managerList,
				projectsWithoutManagers);
		
		assignProjectManagerUi.displayProjects();
		projectIdOfProjectChosen = assignProjectManagerUi.getChosenProjectid();
		
		
		assignProjectManagerUi.displayManagers();
		employeeIdOfManagerChosen = assignProjectManagerUi.getChosenManagerId();
		
		
		try {
			int numRowsEffected = projectEmployeeDao.addProjectManagerAssignemnt(projectIdOfProjectChosen, employeeIdOfManagerChosen);
			if(numRowsEffected == 1){
				System.out.println("Success : Project with id :"+projectIdOfProjectChosen +"has been successfully assigned manager "
						+ "with employee id :"+employeeIdOfManagerChosen);
			}else{
				System.out.println("Failure : Couldn't assign manager to project. Please contact developer at danchara@adobe.com.");
			}
		} catch (PersistenceException e) {
			e.printStackTrace();
		}
		
		
		
		
	}

}
