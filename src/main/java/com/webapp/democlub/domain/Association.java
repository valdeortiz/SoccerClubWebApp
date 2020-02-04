package com.webapp.democlub.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Association{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String type;
	private String name;
	
	@OneToMany(mappedBy = "association")
	List<Employee> members = new ArrayList<>();
	
	public List<Employee> getMembers() {
		return members;
	}
	public void addEmployee(Employee employee) {
		if (!members.contains(employee)) {
			members.add(employee);
		}else {
			System.err.println("Ya existe el empleado: " + employee.getFirstName());
		}
		
	}

	public void setMembers(List<Employee> members) {
		for (Employee employee : members) {
			addEmployee(employee);
		}
		//this.members = members;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
		
}
