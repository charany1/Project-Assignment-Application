/**
 * 
 */
package com.adobe.prj.client.ui;

import java.util.List;
import java.util.Scanner;

import com.adobe.prj.entity.Employee;
import com.adobe.prj.entity.Project;

/**
 * @author danchara
 * 
 * Contains methods that handles user interaction from console for assigning a manager to a
 * project .
 *
 */
public class AssignProjectManagerUi {
	
	
	private List<Employee> managerList;
	private List<Project> projectsWithoutManagers;
	
	private static Scanner inputreader;
	
	
	
	/**
	 * @param managerList
	 * @param projectsWithoutManagers
	 */
	public AssignProjectManagerUi(List<Employee> managerList, List<Project> projectsWithoutManagers) {
		this.managerList = managerList;
		this.projectsWithoutManagers = projectsWithoutManagers;
		inputreader = new Scanner(System.in);
	}
	
	
	/*
	 * Display managers from managerList on console.
	 */
	public  void displayManagers(){
		
		System.out.println("Employee ID\t\tManager Name\t\t");
		for(Employee manager : this.managerList){
			System.out.println(manager.getId()+"\t\t\t"+manager.getName());
		}
		
	}
	
	/*
	 * Get user choice about manager chosen for assignment to project .
	 * @return employee id of manager chosen.
	 */
	
	public int getChosenManagerId(){
		int enteredEmployeeIdOfManager;
		
		
		
		do{
		System.out.println("Please enter id of manager you want to choose from the above shown :");
		
		enteredEmployeeIdOfManager = inputreader.nextInt();
		
		
		if(isEnteredManagerIdValid(enteredEmployeeIdOfManager)){
			break;
			}else{
				System.out.println("Incorrect id entered!!");
			}
		}while(true);
		
		
		
		inputreader.close();
		return enteredEmployeeIdOfManager;
	}
	
	private boolean isEnteredManagerIdValid(int enteredEmployeeIdOfManager) {
		
		if(enteredEmployeeIdOfManager<= 0){
			return false;
		}
		
		boolean isValidId = false;
		
		for(Employee manager : this.managerList){
			if(manager.getId() == enteredEmployeeIdOfManager){
				isValidId = true;
			}
		}
		
		return isValidId;
	}


	/*
	 * Display projects from projectsWithoutManagers on console.
	 */
	public void displayProjects(){
		System.out.println("Project ID\t\tProject Name\t\t");
		for(Project project : this.projectsWithoutManagers){
			System.out.println(project.getId()+"\t\t\t"+project.getName());
		}
	}
	
	/*
	 * Get id of project chosen for being assigned a manager from console .
	 * @return id of project chosen
	 */
	public int getChosenProjectid(){
		
		int enteredIdOfProject;
		
		
		
		do{	
			System.out.println("Please chose a project id from above shown :");
			enteredIdOfProject = inputreader.nextInt();
			
			if(isValidProjectid(enteredIdOfProject)){
				break;
			}else{
				System.out.println("Incorrect project id !!");
			}
			
		}while(true);
		
		
		return enteredIdOfProject;
		
	}


	private boolean isValidProjectid(int enteredIdOfProject) {
		
		if(enteredIdOfProject<=0){
			return false;
		}
		
		boolean isValidId = false;
		
		for(Project project : this.projectsWithoutManagers){
			if(project.getId() == enteredIdOfProject){
				isValidId = true;
			}
		}
		
		return isValidId;
	}

}
