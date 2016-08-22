/**
 * 
 */
package com.adobe.prj.client;

import java.util.Scanner;

import com.adobe.prj.client.service.AddEmployeeService;
import com.adobe.prj.client.service.AddProjectService;
import com.adobe.prj.client.service.AssignProjectManagerService;
import com.adobe.prj.client.service.AssignProjectStaffService;
import com.adobe.prj.client.service.ProjectListingService;

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
	public static Scanner inputReader = new Scanner(System.in);
	public static void main(String[] args) {
		
		int choice;
		System.out.println("Project Management System");
		do{
			
			System.out.println("1.Add Project");
			System.out.println("2.Add Employee");
			System.out.println("3.Assign Manager to Project");
			System.out.println("4.Add Staff to Project");
			System.out.println("5.Display Project Details");
			System.out.println("0.Quit");
			System.out.println("Enter your choice");
			choice = inputReader.nextInt();
			switch(choice){
			case 1:AddProjectService.getAndAddProject();
			       break;
			case 2:AddEmployeeService.getAndAddEmployee();
			       break;
			case 3:AssignProjectManagerService.assignManagerToProject();
		           break;
		    case 4:AssignProjectStaffService.assignStaffToProject();
	               break;
		    case 5:ProjectListingService.getAndShowProjectListing();
		           break;
		    case 0:for(int i=0;i<1000;i++){
		    	       System.out.println("\b");
		            }
		           inputReader.close();
		    	   System.exit(0);
		    	   break;
		    default:System.out.println("Invalid input");
		            break;
			}
		}while(true);

	}

}
