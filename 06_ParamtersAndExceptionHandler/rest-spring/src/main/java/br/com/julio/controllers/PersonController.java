package br.com.julio.controllers;

import br.com.julio.model.Person;
import br.com.julio.service.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.lang.*;
import java.util.List;


@RestController
@RequestMapping("/person")
public class PersonController {


	private PersonServices service;

	@Autowired
	public PersonController(PersonServices service) {
		this.service = service;
	}

	@RequestMapping(method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Person> findAll() {
		return  service.findAll();
	}

	@RequestMapping(method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Person create(@RequestBody Person person) {
		return  service.create(person);
	}

	@RequestMapping(method = RequestMethod.PUT,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Person update(@RequestBody Person person) {
		return  service.update(person);
	}


	@RequestMapping(value = "/{id}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Person findById(@PathVariable(value = "id") Long id) {
		return service.findById(id);
	}

	@RequestMapping(value = "/{id}")
	public void delete(@PathVariable(value = "id") String id) {
		service.delete(id);
	}

}
