package com.webapp.democlub.service;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapp.democlub.domain.Association;
import com.webapp.democlub.domain.Employee;
import com.webapp.democlub.repository.AssociationRepository;
import com.webapp.democlub.repository.EmployeeRepository;


@Service
public class AssociationService {

	@Autowired /*Esto significa que vamos a inyectar*/
	private AssociationRepository associationRepository;
	@Autowired /*Esto significa que vamos a inyectar*/
	private EmployeeRepository employeeRepository;
	
	
	public List<Association> findAll(){
		List<Association> associations = new ArrayList<>();
		Iterator<Association> associationIt = associationRepository.findAll().iterator();
		while(associationIt.hasNext()) {
			associations.add(associationIt.next());
		}
		return associations;
	}
	
	public void insAssociation(Long id, String association) {
		Employee employee = employeeRepository.findById(id).orElse(null);
		Association associationa = associationRepository.findByName(association);
		if (employee != null && associationa != null) {
			associationa.addEmployee(employee);
			employee.setAssociation(associationa);
			associationRepository.save(associationa);
		}else {
			System.err.println("No existe el empledo o la asociacion");
		}
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
