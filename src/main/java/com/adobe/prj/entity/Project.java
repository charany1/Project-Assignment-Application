/**
 * 
 */
package com.adobe.prj.entity;


/**
 * @author rahujai
 *
 */
public class Project {
	private String id;
	private String name;
	private boolean hasProjectManager;
	/**
	 * @param id
	 * @param name
	 * @param hasProjectManager
	 */
	public Project(String id, String name, boolean hasProjectManager) {
		this.id = id;
		this.name = name;
		this.hasProjectManager = hasProjectManager;
	}
	/**
	 * @return the id
	 */
	public final String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public final void setId(String id) {
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
