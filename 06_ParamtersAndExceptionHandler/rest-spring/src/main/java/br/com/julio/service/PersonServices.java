package br.com.julio.service;

import br.com.julio.exceptions.ResourceNotFoudException;

import br.com.julio.mapper.DozerMapper;
import br.com.julio.model.Person;
import br.com.julio.repositories.PersonRepository;
import br.com.julio.vo.v1.PersonVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    @Autowired
    PersonRepository repository;

    public List<PersonVO> findAll() {
       logger.info("Finding all peolpe");
        return DozerMapper.parseListObjects(repository.findAll(), PersonVO.class);
    }

    public PersonVO findById(Long id) {
        logger.info("Finding one Person!");
        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoudException(" No records found for this ID!"));
        return DozerMapper.parseObject(entity, PersonVO.class);
    }

    public PersonVO  create(PersonVO person) {
        logger.info("Creating one Person");
        var entity = DozerMapper.parseObject(person, Person.class);
        return DozerMapper.parseObject(repository.save(entity), PersonVO.class);
    }

    public PersonVO  update(PersonVO person) {
        logger.info("updating one Person");
        var entity = repository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoudException(" No records found for this ID!"));

          entity.setFirstName(person.getFirstName());
          entity.setLastName(person.getLastName());
          entity.setAddress(person.getAddress());
          entity.setGender(person.getGender());

        return DozerMapper.parseObject(repository.save(entity), PersonVO.class);
    }

    public void delete(Long id) {

        logger.info("Deleting a unique person in database");

        var entity  =  repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoudException("No records found for this ID!"));
        repository.delete(entity);
    }
}
