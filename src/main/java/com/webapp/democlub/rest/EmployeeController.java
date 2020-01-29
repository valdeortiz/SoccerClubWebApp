package com.webapp.democlub.rest;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.webapp.democlub.domain.Employee;
import com.webapp.democlub.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Employee greetings(@PathVariable("id") Long id) {
        Employee employee = employeeService.findById(id);
        return employee;
    }
    @RequestMapping(value = "/prom/{id}", method = RequestMethod.GET)
    public Float average(@PathVariable("id") Long id) {
        Float average = employeeService.promedio(id);
        return average;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Employee> list() {
        return employeeService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void add(@RequestBody Employee employee) {
    	employeeService.save(employee);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id) {
    	employeeService.delete(id);
    }

}