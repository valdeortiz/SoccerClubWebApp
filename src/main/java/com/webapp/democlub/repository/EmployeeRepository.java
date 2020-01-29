package com.webapp.democlub.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.webapp.democlub.domain.Employee;

@RepositoryRestResource(collectionResourceRel = "employee", path = "employee")
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {
	//List<Employee> findByTeam(Team team);
	
}
