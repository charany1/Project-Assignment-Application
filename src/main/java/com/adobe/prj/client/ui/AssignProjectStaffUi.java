/**
 * 
 */
package com.adobe.prj.client.ui;

import java.util.List;

import com.adobe.prj.client.Application;
import com.adobe.prj.entity.Employee;
import com.adobe.prj.entity.Project;

/**
 * @author danchara
 * User interaction for feautre d)Assign staff to project .
 */
public class AssignProjectStaffUi {
	
	
	private List<Employee> staffList;
	private List<Project> projectList;
	/**
	 * @param staffList
	 * @param projectList
	 */
	public AssignProjectStaffUi(List<Employee> staffList, List<Project> projectList) {
		this.staffList = staffList;
		this.projectList = projectList;
		}
	
	
	/*
	 * Display staff from staffList on console.
	 */
	public  void displayStaffList(){
		
		System.out.println("Employee ID\t\tStaff Name\t\t");
		for(Employee staff : this.staffList){
			System.out.println(staff.getId()+"\t\t\t"+staff.getName());
		}
		
	}
	
	
	/*
	 * Get user choice about staff chosen for assignment to project .
	 * @return employee id of staff chosen.
	 */
	
	public int getChosenStaffId(){
		int enteredEmployeeIdOfStaff;
		
		
		
		do{
		System.out.println("Please enter id of staff you want to choose from the above shown :");
		
		enteredEmployeeIdOfStaff = Application.inputReader.nextInt();
		
		
		if(isEnteredStaffIdValid(enteredEmployeeIdOfStaff)){
			break;
			}else{
				System.out.println("Incorrect id entered!!");
			}
		}while(true);
		
		
		return enteredEmployeeIdOfStaff;
	}


	private boolean isEnteredStaffIdValid(int enteredEmployeeIdOfStaff) {
		
		if(enteredEmployeeIdOfStaff<= 0){
			return false;
		}
		
		boolean isValidId = false;
		
		for(Employee staff : this.staffList){
			if(staff.getId() == enteredEmployeeIdOfStaff){
				isValidId = true;
			}
		}
		
		return isValidId;
		
	}
	
	/*
	 * Display all projects from projectList on  console.
	 */
	public void displayProjects(){
		System.out.println("Project ID\t\tProject Name\t\t");
		for(Project project : this.projectList){
			System.out.println(project.getId()+"\t\t\t"+project.getName());
		}
	}
	
	/*
	 * Get id of project chosen for being assigned a staff from console .
	 * @return id of project chosen
	 */
	public int getChosenProjectid(){
		
		int enteredIdOfProject;
		
		
		
		do{	
			System.out.println("Please chose a project id from above shown :");
			enteredIdOfProject = Application.inputReader.nextInt();
			
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
		
		for(Project project : this.projectList){
			if(project.getId() == enteredIdOfProject){
				isValidId = true;
			}
		}
		
		return isValidId;
	}


}
