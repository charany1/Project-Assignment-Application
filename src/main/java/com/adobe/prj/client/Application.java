/**
 * 
 */
package com.adobe.prj.client;

import com.adobe.prj.client.service.AddEmployeeService;
import com.adobe.prj.client.service.AddProjectService;
import com.adobe.prj.client.service.AssignProjectManagerService;
import com.adobe.prj.client.ui.AddEmployeeUi;
import com.adobe.prj.dao.EmployeeDao;
import com.adobe.prj.dao.PersistenceException;
import com.adobe.prj.dao.jdbc.EmployeeDaoJdbcImpl;
import com.adobe.prj.entity.Employee;

/**
 * @author rahujai
 * @author danchara
 *
 * @version 1.0
 * 
 * 
 * Entry point for interacting with application .
 */
public class Application {

	/**
	 * @param args
	 */

	//private static ProjectDao pd = ProjectDaoFactory.getProjectDao();
	//private static EmployeeDao ed = EmployeeDaoFactory.getEmployeeDao();
	/*
	private static void addStaff() {
		List<Project> projects = pd.getAllProjects();
		System.out.println("Existing projects: ");
		projects.forEach(p -> System.out.println(p.getName()));
		
		List<Employee> emps = ed.getExistingEmployees();
		System.out.println("Existing employees: ");
		emps.forEach(p -> System.out.println(p.getFirst_name() + " " + p.getLast_name()));
		
		//TODO assign employees

	}
	
	private static void assignPm(){
		List<Project> projects = pd.getExistingProjects();
		System.out.println("Existing projects: ");
		projects.forEach(p -> System.out.println(p.getName()));
		
		List<Employee> pms = ed.getExistingProjectManagers();
		System.out.println("Existing project managers: ");
		pms.forEach(p -> System.out.println(p.getFirst_name() + " " + p.getLast_name()));

		if(projects.size() > pms.size()){
			System.out.println("Insufficient number of Project Managers");
			return;
		}
		Iterator<Project> ip = projects.iterator();
		Iterator<Employee> ie = pms.iterator();
		while(ip.hasNext()){
			ip.next().setPm_id(ie.next().getId());
		}
	}
	
	private static void output() {
		List<Project> projects = pd.getAllProjects();
		projects.forEach((p) -> {
			System.out.println("Project : " + p.getName());
			Employee pm = ed.getEmployee(p.getPm_id());
			System.out.println("Project Manager : " + pm.getFirst_name() + " " + pm.getLast_name()); //TODO Exception when no manager
			System.out.println("Staff :");
			List<Employee> emps = ed.getEmployeesOfProject(p.getId());
			int count = 0;
			Iterator<Employee> ie = emps.iterator();
			while(ie.hasNext()) {
				Employee emp = ie.next();
				System.out.println((++count) + ". " + emp.getFirst_name() + " " + emp.getLast_name());
			}
		});
	}
	*/
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//AddEmployeeService.getAndAddEmployee();
		
		//AddProjectService.getAndAddProject();
		
		AssignProjectManagerService.assignManagerToProject();
		
		
		
		
	}

}
