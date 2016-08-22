/**
 * 
 */
package com.adobe.prj.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author rahujai
 *	@author danchara 
 *
 */

@XmlRootElement(name="employee")
@XmlAccessorType(XmlAccessType.FIELD)

public class Employee {
	
	private int id;
	private String name;
	private String email;
	private Role role;
	/**
	 * @param id
	 * @param name
	 * @param email
	 * @param role
	 */
	public Employee(int id, String name, String email, int role) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.role = Role.values()[role];
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
	public Employee() {
		super();
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
	 * @return the email
	 */
	public final String getEmail() {
		return email;
	}


	/**
	 * @param email the email to set
	 */
	public final void setEmail(String email) {
		this.email = email;
	}


	/**
	 * @return the role
	 */
	public final Role getRole() {
		return role;
	}


	/**
	 * @param role the role to set
	 */
	public final void setRole(int role) {
		this.role = Role.values()[role];
	}


	
	
	
	/**
	 * 
	 * @param name
	 * @param email
	 * @param role
	 */
	public Employee( String name, String email, int role) {
		
		this.name = name;
		this.email = email;
		this.role = Role.values()[role];;
	}
	
	
	
	
}
