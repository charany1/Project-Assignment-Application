/**
 * 
 */
package com.adobe.prj.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author rahujai
 *
 */

@XmlRootElement(name="project")
@XmlAccessorType(XmlAccessType.FIELD)

public class Project {
	private int  id;
	private String name;
	private boolean hasProjectManager;
	/**
	 * @param id
	 * @param name
	 * @param hasProjectManager
	 */
	public Project(int id, String name, boolean hasProjectManager) {
		this.id = id;
		this.name = name;
		this.hasProjectManager = hasProjectManager;
	}
	/**
	 * @return the id
	 */
	public final int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public final void setId(int id) {
		this.id = id;
	}
	
	/**
	 * 
	 */
	public Project() {
		super();
	}
	/**
	 * 
	 * @param name
	 * @param hasProjectManager
	 */
	public Project( String name, boolean hasProjectManager) {
		
		this.name = name;
		this.hasProjectManager = hasProjectManager;
	}
	public Project(String projectName) {
		
		this.name = projectName;
	
	}
	/**
	 * @return the name
	 */
	public final String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public final void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the hasProjectManager
	 */
	public final boolean isHasProjectManager() {
		return hasProjectManager;
	}
	/**
	 * @param hasProjectManager the hasProjectManager to set
	 */
	public final void setHasProjectManager(boolean hasProjectManager) {
		this.hasProjectManager = hasProjectManager;
	}
	
	
	
}
