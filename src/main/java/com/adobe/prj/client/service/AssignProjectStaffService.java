/**
 * 
 */
package com.adobe.prj.client.service;

import java.util.ArrayList;
import java.util.List;

import com.adobe.prj.client.ui.AssignProjectStaffUi;
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
 *
 * For feature d) Assign staff to project .
 * 
 * 
 *  Service class that combines methods for : 
 *  1. Fetch all projects => ProjectDao#getAllProjects
 *  2. Fetch staff member => EmployeeDao#getStaffEmployees
 *  3. Display projects on console => AssignProjectStaffUi#displayProjects
 *  4. Display staff members on console => AssignProjectStaffUi#displayStaffList
 *  5. Get project choice from console => AssignProjectStaffUi#getChosenProjectId
 *  6. Get staff choice from console => AssignProjectStaffUi#getChosenStaffId
 *  7. Save project-staff assignment in project_employee table => ProjectEmployeeDao#addProjectStaffAssignment
 *  
 */
public class AssignProjectStaffService {
	
	public static void assignStaffToProject(){
			
		int employeeIdOfStaffChosen;
		int projectIdOfProjectChosen;
		
		List<Project> projectList = new ArrayList<Project>();
		List<Employee> staffList = new ArrayList<Employee>();
		
		ProjectDao projectDao = new ProjectDaoJdbcImpl();
		EmployeeDao employeeDao = new EmployeeDaoJdbcImpl();
		ProjectEmployeeDao projectEmployeeDao = new ProjectEmployeeDaoJdbcImpl();
		
		
		try {
			projectList = projectDao.getAllProjects();
		} catch (FetchException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			staffList = employeeDao.getStaffEmployees();
		} catch (FetchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		AssignProjectStaffUi assignProjectStaffUi = new AssignProjectStaffUi(staffList, projectList);
		
		assignProjectStaffUi.displayProjects();
		projectIdOfProjectChosen = assignProjectStaffUi.getChosenProjectid();
		
		assignProjectStaffUi.displayStaffList();
		employeeIdOfStaffChosen = assignProjectStaffUi.getChosenStaffId();
		
		try {
			int numRowsEffected = projectEmployeeDao.addProjectStaffAssignment(projectIdOfProjectChosen,
					employeeIdOfStaffChosen);
			
			if(numRowsEffected==1){
				System.out.println("Success : Project with id :"+projectIdOfProjectChosen +"has been successfully assigned staff "
						+ "with employee id :"+employeeIdOfStaffChosen);
			}else{
				System.out.println("Failure : Couldn't assign staff to project. Please contact developer at danchara@adobe.com.");
			}
		} catch (PersistenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
