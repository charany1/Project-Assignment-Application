package com.adobe.prj.client.ui;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.adobe.prj.dao.EmployeeDao;
import com.adobe.prj.dao.FetchException;
import com.adobe.prj.dao.jdbc.EmployeeDaoJdbcImpl;
import com.adobe.prj.entity.Employee;

public class Testing {

	public static void main(String[] args) {
		
		List<Employee> list = new ArrayList<Employee>();
		Employee b;
		
		EmployeeDao employeeDao=new EmployeeDaoJdbcImpl();
		try {
			list=employeeDao.getAllEmployees();
		} catch (FetchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Iterator<Employee> iter=list.iterator();
		while(iter.hasNext()){
				b=iter.next();
				System.out.println("Id"+b.getId()+"Name:"+b.getName()+"Email"+b.getEmail());
		}
		
	}

}
