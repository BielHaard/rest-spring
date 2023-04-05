package br.com.julio.service;

import br.com.julio.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private static final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonServices.class.getName());


    public List<Person> findAll() {
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i<8; i++){
            Person person = mockPerson(i);
            persons.add(person);
        }
        return persons;
    }

    private Person mockPerson(int i) {

        logger.info("Finding All People!");
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Person Name " + i);
        person.setLastName("Last Name " + i);
        person.setAdress("Som Adress in Brasil "+ i);
        person.setGender("Male");
        return person;
    }

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
