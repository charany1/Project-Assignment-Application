/**
 * 
 */
package com.adobe.prj.client.service;

import java.util.List;

import com.adobe.prj.client.ui.ProjectListingUi;
import com.adobe.prj.dao.FetchException;
import com.adobe.prj.dao.ProjectEmployeeDao;
import com.adobe.prj.dao.jdbc.ProjectEmployeeDaoJdbcImpl;
import com.adobe.prj.dto.ProjectDetailsDto;

/**
 * @author danchara
 * 
 * Service class that combines methods for 
 * 1. Get list of ProjectDetailsDto => ProjectEmployeeDao#getAllProjectsDetailsForListing
 * 2. Display listing of projects => ProjectListingUi#displayProjectListing
 */
public class ProjectListingService {
	
	public static void getAndShowProjectListing(){
		ProjectEmployeeDao projectEmployeeDao = new ProjectEmployeeDaoJdbcImpl();
		
		List<ProjectDetailsDto> projectDetailsDtoList = null ;
		
		try {
			projectDetailsDtoList = projectEmployeeDao.getAllProjectsDetailsForListing();
		} catch (FetchException e) {
			e.printStackTrace();
		}
		
		ProjectListingUi.displayProjectListing(projectDetailsDtoList);
	}

}
