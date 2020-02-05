package com.webapp.democlub.rest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> greetings(@PathVariable("id") Long id) {
    	Employee employee = null;
    	Map<String, Object> response = new HashMap<>();
    	try {
    		employee = employeeService.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la conexion a la base de datos");
			response.put("error",e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
         
        if (employee == null) {
        	response.put("mensaje", "El id no existe en la base de datos");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
        return new ResponseEntity<Employee>(employee, HttpStatus.OK);
    }
    @RequestMapping(value = "/prom/{id}", method = RequestMethod.GET)
    public Double average(@PathVariable("id") Long id) {
        Double average = employeeService.promedio(id);
        return average;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Employee> list() {
        return employeeService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> add(@RequestBody Employee employee) {
    	Employee newEmployee = null;
    	Map<String, Object> response = new HashMap<>();
    	try {
    		newEmployee = employeeService.save(employee);
		} catch (Exception e) {
			response.put("mensaje", "Error al insertar el employee a la base de datos");
			response.put("error",e.getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
        response.put("mensaje", "El employee ha sido creado con exito");
        response.put("employee", newEmployee);
    	return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id) {
    	employeeService.delete(id);
    }

}