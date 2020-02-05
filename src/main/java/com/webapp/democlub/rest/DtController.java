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

import com.webapp.democlub.domain.Dt;
import com.webapp.democlub.exception.InscripcionException;
import com.webapp.democlub.service.DtService;

@RestController
@RequestMapping("/dt")
public class DtController {

	@Autowired
	private DtService dtService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> greetings(@PathVariable("id") Long id) {
    	Dt dt = null;
    	Map<String, Object> response = new HashMap<>();
    	try {
    		dt = dtService.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la conexion a la base de datos");
			response.put("error",e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
         
        if (dt == null) {
        	response.put("mensaje", "El id no existe en la base de datos");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
        return new ResponseEntity<Dt>(dt, HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Dt> list() {
        return dtService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> add(@RequestBody Dt dt) throws InscripcionException {
    	Dt newDt = null;
    	Map<String, Object> response = new HashMap<>();
    	try {
    		newDt = dtService.save(dt);
		} catch (Exception e) {
			response.put("mensaje", "Error al insertar el dt a la base de datos");
			response.put("error",e.getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
        response.put("mensaje", "El dt ha sido creado con exito");
        response.put("dt", newDt);
    	return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }
    
    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<?> addPut(@RequestBody Dt dt) {
    	Dt newDt = null;
    	Map<String, Object> response = new HashMap<>();
    	try {
    		newDt = dtService.savePut(dt);
		} catch (Exception e) {
			response.put("mensaje", "Error al insertar el dt a la base de datos");
			response.put("error",e.getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
        response.put("mensaje", "El dt ha sido creado con exito");
        response.put("dt", newDt);
    	return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id) {
    	dtService.delete(id);
    }
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void deleteAll() {
    	dtService.deleteAll();
    }

}