/**
 * 
 */
package com.adobe.prj.client.ui;

import com.adobe.prj.client.Application;
import com.adobe.prj.entity.Project;

/**
 * @author danchara
 * 
 * Class for getting project information(name of project) from console .
 *
 */
public class AddProjectUi {
	
	
	/*
	 *  For getting project info from console .
	 *  @return Project newly added project
	 * */
	public static Project getProjectDetailsFromConsole(){
		
		Project project ;
		
		String projectName;
		
		
		do{
			Application.inputReader.nextLine();
			System.out.println("Enter the name of the project :");
			projectName = Application.inputReader.nextLine();
			if(projectName==null||projectName.trim().equals("")){
				System.out.println("Please enter the project name correctly : ");
			}else{
				break;
			}
			
		}while(true);
		
		project = new Project(projectName);
		
		return project;
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Project project = getProjectDetailsFromConsole();
		System.out.println("Name :"+ project.getName());
		System.out.println("HPM :"+ project.isHasProjectManager());

	}

}
