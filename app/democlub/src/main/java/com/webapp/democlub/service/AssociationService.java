package com.webapp.democlub.service;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapp.democlub.domain.Association;
import com.webapp.democlub.repository.AssociationRepository;


@Service
public class AssociationService {

	@Autowired /*Esto significa que vamos a inyectar*/
	private AssociationRepository associationRepository;
	
	
	public List<Association> findAll(){
		List<Association> associations = new ArrayList<>();
		Iterator<Association> associationIt = associationRepository.findAll().iterator();
		while(associationIt.hasNext()) {
			associations.add(associationIt.next());
		}
		return associations;
	}
 
	public Association findById(Long id) {
		Association association = associationRepository.findById(id).orElse(null);
		return association;
	}

	public void save(Association association) {
		associationRepository.save(association);
	}
	
	public void delete(Long id) {
		associationRepository.deleteById(id);
	}
	
	

}
