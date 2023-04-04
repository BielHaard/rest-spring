package br.com.julio.service;

import br.com.julio.model.Person;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private static final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonServices.class.getName());


    public Person findById(String id) {

        logger.info("Finding one Person!");

        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Júlio");
        person.setLastName("Garcia");
        person.setAdress("São Paulo - São Paulo - Brasil");
        person.setGender("Male");
        return person;
    }
}
