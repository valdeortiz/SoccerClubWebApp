package com.webapp.democlub.rest;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.webapp.democlub.domain.Executive;
import com.webapp.democlub.service.ExecutiveService;

/*
* Creamos nuestro controlador rest que mapea las direcciones para poder utilizar las funciones del service
* colocamos la direccion donde nuestro cliente se va a conectar a nuestro api
* e implementamos los metodos crud.
*/

@RestController
@RequestMapping("/executive")
public class ExecutiveController {

	@Autowired
	private ExecutiveService executiveService;
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Executive> findAll(){
		return executiveService.findAll();
	}
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Executive greetings(@PathVariable("id") Long id) {
        Executive executive = executiveService.findById(id);
        return executive;
    }

    @RequestMapping(method = RequestMethod.POST)
    public void add(@RequestBody Executive executive) {
    	executiveService.save(executive);
    }
    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<?> addPut(@RequestBody Executive executive) {
    	Executive newExecutive = null;
    	Map<String, Object> response = new HashMap<>();
    	try {
    		newExecutive = executiveService.savePut(executive);
		} catch (Exception e) {
			response.put("mensaje", "Error al insertar el executive a la base de datos");
			response.put("error",e.getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
        response.put("mensaje", "El executive ha sido modificado con exito");
        response.put("executive", newExecutive);
    	return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    	
    	
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id) {
    	executiveService.delete(id);
    }

}