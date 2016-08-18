package com.adobe.prj.dto;

import java.util.ArrayList;
import java.util.List;

/*
 * @author danchara
 * 
 * 
 * Provides a data transfer object , used when we get data from db for each project to show  on console to user .
 */
public class ProjectDetailsDto {
	
	private String projectId;
	private String projectName;
	private String managerName;
	private List<String> staff = new ArrayList<String>();
	/**
	 * @return the projectId
	 */
	public final String getProjectId() {
		return projectId;
	}
	/**
	 * @param projectId the projectId to set
	 */
	public final void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	/**
	 * @return the projectName
	 */
	public final String getProjectName() {
		return projectName;
	}
	/**
	 * @param projectName the projectName to set
	 */
	public final void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	/**
	 * @return the managerName
	 */
	public final String getManagerName() {
		return managerName;
	}
	/**
	 * @param managerName the managerName to set
	 */
	public final void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	/**
	 * @return the staff
	 */
	public final List<String> getStaff() {
		return staff;
	}
	/**
	 * @param staff the staff to set
	 */
	public final void setStaff(List<String> staff) {
		this.staff = staff;
	}
	/**
	 * @param projectId
	 * @param projectName
	 * @param managerName
	 * @param staff
	 */
	public ProjectDetailsDto(String projectId, String projectName, String managerName, List<String> staff) {
		this.projectId = projectId;
		this.projectName = projectName;
		this.managerName = managerName;
		this.staff = staff;
	}
	

}
