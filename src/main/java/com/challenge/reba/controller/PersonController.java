package com.challenge.reba.controller;

import com.challenge.reba.dto.PersonDTO;
import com.challenge.reba.exception.PersonExistingException;
import com.challenge.reba.model.Person;
import com.challenge.reba.service.IPersonService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/person")
public class PersonController {
    Logger logger = LoggerFactory.getLogger(PersonController.class);

    @Autowired
    private IPersonService personService;

    /**
     *
     * @param id
     * @return a person by id
     */
    @GetMapping(value = "/get/{id}")
    public Person findById(@PathVariable(required = true) Long id){
        logger.info("Id:{}", id);

        return personService.findById(id);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteById(@PathVariable(required = true) Long id){
        logger.info("Person id to delete:{}", id);

        personService.deleteById(id);
    }


    @PostMapping(value = "/create")
    public ResponseEntity<Person> create(@RequestBody @Valid PersonDTO personDTO) throws PersonExistingException {
        logger.info("Create person:{}", personDTO);
        Person newPerson = personService.create(personDTO);

        if(newPerson == null){
            throw new PersonExistingException("Failed to create newPerson:"+personDTO);
        } else {
            return new ResponseEntity<>(newPerson, HttpStatus.CREATED);
        }
    }

    /**
     *
     * @return a JSON with all persons
     */
    @GetMapping(value = "/findAll")
    public @ResponseBody Iterable<Person> findAll() {
        return personService.findAll();
    }
}
