package com.challenge.reba.service;

import com.challenge.reba.dto.PersonDTO;
import com.challenge.reba.exception.DocumentTypeNotFoundException;
import com.challenge.reba.model.Person;

import java.util.List;

public interface IPersonService {

    Person create(PersonDTO personDTO);
    Person findById(Long id);
    void deleteById(Long id);
    List<Person> findAll();
}
