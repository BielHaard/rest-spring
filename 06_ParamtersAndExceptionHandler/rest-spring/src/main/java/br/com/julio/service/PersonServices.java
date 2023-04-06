package br.com.julio.service;

import br.com.julio.exceptions.ResourceNotFoudException;
import br.com.julio.model.Person;
import br.com.julio.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    @Autowired
    PersonRepository repository;

    public List<Person> findAll() {
       logger.info("Finding all peolpe");
        return repository.findAll();
    }

    public Person findById(Long id) {
        logger.info("Finding one Person!");
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoudException(" No records found for this ID!"));
    }

    public Person  create(Person person) {
        logger.info("Creating one Person");
        return repository.save(person);
    }

    public Person  update(Person person) {
        logger.info("Creating one Person");
        Person entity = repository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoudException(" No records found for this ID!"));

          entity.setFirstName(person.getFirstName());
          entity.setLastName(person.getLastName());
          entity.setAdress(person.getAdress());
          entity.setGender(person.getGender());

        return repository.save(entity);
    }

    public void delete(String id) {

        logger.info("Deleting a unique person in database");

    }
}
