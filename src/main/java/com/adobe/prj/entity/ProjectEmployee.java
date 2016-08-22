package com.adobe.prj.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="projectemployee")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProjectEmployee {
	
	int project_id;
	int emplloyee_id;
	public ProjectEmployee() {
	}
	public ProjectEmployee(int project_id, int emplloyee_id) {
		this.project_id = project_id;
		this.emplloyee_id = emplloyee_id;
	}
	/**
	 * @return the project_id
	 */
	public final int getProject_id() {
		return project_id;
	}
	/**
	 * @param project_id the project_id to set
	 */
	public final void setProject_id(int project_id) {
		this.project_id = project_id;
	}
	/**
	 * @return the emplloyee_id
	 */
	public final int getEmplloyee_id() {
		return emplloyee_id;
	}
	/**
	 * @param emplloyee_id the emplloyee_id to set
	 */
	public final void setEmplloyee_id(int emplloyee_id) {
		this.emplloyee_id = emplloyee_id;
	}
	

}
