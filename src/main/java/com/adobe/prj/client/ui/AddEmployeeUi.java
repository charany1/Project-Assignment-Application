/**
 * 
 */
package com.adobe.prj.client.ui;

import java.util.Scanner;

import com.adobe.prj.entity.Employee;

/**
 * @author danchara
 *	
 * Class for getting employee details(name,email,role:[0:STAFF|1:MANAGER]) for addition to db . 
 */
public class AddEmployeeUi {
	
	
	/*
	 * Gets employee information from console .
	 * 
	 *  @return Employee newly added employee
	 */
	public static Employee getEmployeeDetailsFromConsole(){
		
		Employee employee;
		
		
		
		String employeeName = null;
		String employeeEmail = null;
		int role =-1;
		
		Scanner inputreader=new Scanner(System.in);
		
		
		do{
		    System.out.println("Enter the name of the employee");
			employeeName = inputreader.nextLine();
			if(employeeName==null||employeeName.trim().equals("")){
				System.out.println("Please enter employee name correctly : ");
			}else{
				break;
			}
			
		}while(true);
		
		
		
		
		
		do{
			System.out.println("Enter the e-mail id of the employee");
			employeeEmail=inputreader.nextLine();
			if(employeeEmail==null||employeeEmail.trim().equals("") ||(!isValidEmailAddress(employeeEmail))){
				System.out.println("Please enter you email correctly : ");
				continue;
			}else{
				break;
			}
		}while(true);
		
		
		do{
			System.out.println("Is this employee a staff member(enter 0) or project manager(enter 1) ?");
			role=inputreader.nextInt();
			if((role== -1) || !(role==0||role==1)){
				System.out.println("Please enter the choice correctly");
			}else{
				break;
			}
		}while(true);	
		
		inputreader.close();
		
		employee = new Employee(employeeName,employeeEmail,role);
		
		return employee;
	}
	
	
	
	private static boolean isValidEmailAddress(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
 }
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Employee employee = getEmployeeDetailsFromConsole();
		
		System.out.println("Name : "+ employee.getName());
		System.out.println("Email: "+ employee.getEmail());
		System.out.println("Role : "+ employee.getRole());
		
	}

}
