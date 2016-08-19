/**
 * 
 */
package com.adobe.prj.client.ui;

import java.util.List;

import com.adobe.prj.dto.ProjectDetailsDto;

/**
 * @author danchara
 * For listing project info for requirement (e)
 */
public class ProjectListingUi {
	
	
	/*
	 * Displays individual project.
	 * @param projectDetailsDto Dto of project to be displayed.
	 */
	public  static void displayProjectInformation(ProjectDetailsDto projectDetailsDto){
		System.out.println("PROJECT : "+projectDetailsDto.getProjectName());
		StringBuilder managerStringBuilder = new StringBuilder("MANAGER : ");
		
		if(projectDetailsDto.getManagerName()!= null){
			managerStringBuilder.append(projectDetailsDto.getManagerName());
		}
		
		System.out.println(managerStringBuilder.toString());
		
		System.out.println("STAFF : ");
		
		List<String> staffList = projectDetailsDto.getStaff();
		
		int employeeSerialNumber =1;
		for(String staffMember : staffList ){
			System.out.println("\t\t"+employeeSerialNumber+". "+staffMember);
			employeeSerialNumber += 1;
		}
		
		System.out.println("\n\n");
		
		
	}
	
	
	/*
	 * Displays project listing . 
	 * @param projectDetailsDtoList list of ProjectDetailsDto 
	 */
	public static void displayProjectListing(List<ProjectDetailsDto> projectDetailsDtoList){
		for(ProjectDetailsDto projectDetailsDto :projectDetailsDtoList ){
			displayProjectInformation(projectDetailsDto);
		}
	}

}
