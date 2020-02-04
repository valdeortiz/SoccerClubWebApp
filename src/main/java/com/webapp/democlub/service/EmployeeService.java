package com.webapp.democlub.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapp.democlub.domain.Association;
import com.webapp.democlub.domain.Employee;
import com.webapp.democlub.domain.Team;
import com.webapp.democlub.repository.AssociationRepository;
import com.webapp.democlub.repository.EmployeeRepository;
import com.webapp.democlub.repository.TeamRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private AssociationRepository asoRepo;
	
	@Autowired
	private TeamRepository teamRepo;
		
	public Employee findById(Long id) {
		Employee employee = employeeRepository.findById(id).orElse(null);
		return employee;
	}
	public Double promedio(Long id) {
		Employee employee = findById(id);
		return employee != null ? employee.getAverage_salary() : 0.0 ;
		
	}
	
	public List<Employee> findAll() {
		List<Employee> employees = new ArrayList<>();
		Iterator<Employee> iteratorEmployees = employeeRepository.findAll().iterator();
		while (iteratorEmployees.hasNext()) {
			employees.add(iteratorEmployees.next());
		}
		return employees ;
	}
	
	public void save(Employee employee) {
		Association aso = asoRepo.findByName(employee.getAssociation());
		Team team = teamRepo.findByName(employee.getTeam());
		if (aso != null && team != null) {
			team.addEmployee(employee);
			employee.setTeamName(team.getName());
			aso.addEmployee(employee);
			employee.setAssociation(aso);
		}else {
			System.err.println("No existe asociacion o team ");
		}
		employeeRepository.save(employee);
	}

	public void delete(Long id) {
		employeeRepository.deleteById(id);
	}

}
