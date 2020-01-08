package com.webapp.democlub.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.webapp.democlub.domain.Directivo;
import com.webapp.democlub.service.DirectivoService;

/*
* Creamos nuestro controlador rest que mapea las direcciones para poder utilizar las funciones del service
* colocamos la direccion donde nuestro cliente se va a conectar a nuestro api
* e implementamos los metodos crud.
*/

@RestController
@RequestMapping("/directivo")
public class DirectivoController {

	@Autowired
	private DirectivoService directivoService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Directivo greetings(@PathVariable("id") Long id) {
        Directivo directivo = directivoService.findById(id);
        return directivo;
    }

    @RequestMapping(method = RequestMethod.POST)
    public void add(@RequestBody Directivo directivo) {
    	directivoService.save(directivo);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id) {
    	directivoService.delete(id);
    }

}