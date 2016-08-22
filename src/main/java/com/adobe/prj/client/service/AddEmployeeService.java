/**
 * 
 */
package com.adobe.prj.client.service;

import com.adobe.prj.client.ui.AddEmployeeUi;
import com.adobe.prj.dao.EmployeeDao;
import com.adobe.prj.dao.PersistenceException;
import com.adobe.prj.dao.jdbc.EmployeeDaoJdbcImpl;
import com.adobe.prj.entity.Employee;

/**
 * @author danchara
 *	
 * Combines task of getting Employee details from console and adding it to database . 
 * Uses AddEmployeeUi and EmployeeDaoJdbcImpl .
 */
public class AddEmployeeService {
	
	public static void getAndAddEmployee(){
		Employee employee = AddEmployeeUi.getEmployeeDetailsFromConsole();
		
		EmployeeDao employeeDao = new EmployeeDaoJdbcImpl();
		/*try {
			employeeDao.getAllEmployees();
		} catch (FetchException e1) {
			System.out.println("Hello World");
			e1.printStackTrace();
		}*/
		
		try {
			int numRowsEffected = employeeDao.addEmployee(employee);
			if(numRowsEffected == 1){
				System.out.println("Employee "+employee.getName()+" added successfully.");
			}
		} catch (PersistenceException e) {
			e.printStackTrace();
		}
	}

}
