package br.com.julio.controller;

import br.com.julio.model.Person;
import br.com.julio.service.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.lang.*;


@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonServices personService;

	@RequestMapping(value = "/{id}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Person findById(@PathVariable(value = "id") String id) throws Exception{
		return personService.findById(id);
	}

}
