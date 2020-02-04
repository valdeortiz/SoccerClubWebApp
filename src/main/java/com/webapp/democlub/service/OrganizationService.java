package com.webapp.democlub.service;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapp.democlub.domain.Organization;
import com.webapp.democlub.repository.OrganizationRepository;


@Service
public class OrganizationService {

	@Autowired /*Esto significa que vamos a inyectar*/
	private OrganizationRepository organizationRepository;
	
	
	public List<Organization> findAll(){
		List<Organization> organizations = new ArrayList<>();
		Iterator<Organization> organizationIt = organizationRepository.findAll().iterator();
		while(organizationIt.hasNext()) {
			organizations.add(organizationIt.next());
		}
		return organizations;
	}
 
	public Organization findById(Long id) {
		Organization organization = organizationRepository.findById(id).orElse(null);
		return organization;
	}
	public Organization findByName(String name) {
		Organization organization = organizationRepository.findByName(name);
		return organization;
	}

//	public void save(Organization organization) {
//		organizationRepository.save(organization);
//	}
	
	public void delete(Long id) {
		organizationRepository.deleteById(id);
	}
	
	

}
