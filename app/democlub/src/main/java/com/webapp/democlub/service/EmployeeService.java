package com.webapp.democlub.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapp.democlub.domain.Employee;
import com.webapp.democlub.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	public Employee findById(Long id) {
		Employee employee = employeeRepository.findById(id).orElse(null);
		return employee;
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
		employeeRepository.save(employee);
	}

	public void delete(Long id) {
		employeeRepository.deleteById(id);
	}

}
