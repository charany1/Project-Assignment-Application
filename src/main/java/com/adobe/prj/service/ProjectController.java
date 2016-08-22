package com.adobe.prj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.adobe.prj.dao.EmployeeDao;
import com.adobe.prj.dao.FetchException;
import com.adobe.prj.dao.PersistenceException;
import com.adobe.prj.dao.ProjectDao;
import com.adobe.prj.dao.ProjectEmployeeDao;
import com.adobe.prj.dao.jdbc.ProjectDaoJdbcImpl;
import com.adobe.prj.dao.jdbc.ProjectEmployeeDaoJdbcImpl;
import com.adobe.prj.dto.ProjectDetailsDto;
import com.adobe.prj.entity.Employee;
import com.adobe.prj.entity.Project;


@Controller
public class ProjectController {
	
	@Autowired
	private EmployeeDao employeeDao;
	private ProjectDao projectDao=new ProjectDaoJdbcImpl();
	private ProjectEmployeeDao projectemployeeDao=new ProjectEmployeeDaoJdbcImpl();
	
	@RequestMapping(value="/employee",method=RequestMethod.GET)
	public @ResponseBody List<Employee> getAllEmployees() throws Exception{
		//System.out.println("Hello");
		try {
			return employeeDao.getAllEmployees();
		} catch (FetchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(NullPointerException e1){
			System.out.println("Null pointer exception");
			//throw new Exception("Null pointer",e1);
		}
		return null;
	}
	
	@RequestMapping(value="/project",method=RequestMethod.GET)
	public @ResponseBody List<Project> getAllProjects(){
		try {
			return projectDao.getAllProjects();
		} catch (FetchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println("World");
		return null;
	}
	
	@RequestMapping(value="/project",method=RequestMethod.POST)
	public ResponseEntity<String> addProject(@RequestBody Project project){//no void
		try {
			projectDao.addProject(project);
		} catch (PersistenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<String>("Project " + project.getName() + " added",HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/employee",method=RequestMethod.POST)
	public ResponseEntity<String> addEmployee(@RequestBody Employee employee){//no void
		try {
			employeeDao.addEmployee(employee);
		} catch (PersistenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<String>("Employee " + employee.getName() + " added",HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/project/details",method=RequestMethod.GET)
	public @ResponseBody List<ProjectDetailsDto> getAllProjectsDetailsForListing(){
		try {
			return projectemployeeDao.getAllProjectsDetailsForListing();
		} catch (FetchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println("World");
		return null;
	}
	
	@RequestMapping(value="/projectemployee/{id}",method=RequestMethod.GET)
	public @ResponseBody List<Project> getProjectsWithoutManagers(){
		try {
			return projectDao.getProjectsWithoutManager();
		} catch (FetchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println("World");
		return null;
	}
	
	@RequestMapping(value="project/{project_id}/manager/{employee_id}",method=RequestMethod.POST)
	public ResponseEntity<String> addProjectManagerAssignment(@PathVariable("project_id") int projectId,@PathVariable("employee_id") int employeeId){//no void
		try {
			projectemployeeDao.addProjectManagerAssignemnt(projectId, employeeId);
		} catch (PersistenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<String>("Project id: " + projectId + "Employee id: "+ employeeId,HttpStatus.CREATED);
	}
	
	@RequestMapping(value="project/{project_id}/staff/{employee_id}",method=RequestMethod.POST)
	public ResponseEntity<String> addProjectStaffAssignment(@PathVariable("project_id") int projectId,@PathVariable("employee_id") int employeeId){//no void
		try {
			projectemployeeDao.addProjectStaffAssignment(projectId, employeeId);
		} catch (PersistenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<String>("Project id: " + projectId + "Employee id: "+ employeeId,HttpStatus.CREATED);
	}
	/*
	@RequestMapping(value="/books/{id}",method=RequestMethod.GET)
	public @ResponseBody Book getBook(@PathVariable("id") int id){
		return bookDao.getBook(id);
	}
	*/
	/*
	@RequestMapping(value="/books/projectmanagerassign",method=RequestMethod.POST)
	public ResponseEntity<String> updateBook(@PathVariable("id") int id,@RequestBody Book book){//no void
		bookDao.updateBook(id,book);
		return new ResponseEntity<String>("Book " + book.getTitle() + " updated",HttpStatus.OK);
	}
	*/
	/*
	@RequestMapping(value="/books/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<String> deleteBook(@PathVariable("id") int id){//no void
		bookDao.deleteBook(id);
		return new ResponseEntity<String>("Book " + id + " deleted",HttpStatus.OK);
	}
	
	@RequestMapping(value="/books/",method=RequestMethod.GET)
	public @ResponseBody List<Book> getBookByPrice(@RequestParam("amt") double price){
		return bookDao.getBookByPrice(price);
	}*/
}
