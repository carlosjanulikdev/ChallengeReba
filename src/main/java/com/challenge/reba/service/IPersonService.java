package com.challenge.reba.service;

import com.challenge.reba.model.Person;

import java.util.List;

public interface IPersonService {

    Person create(Person person);
    Person findById(Long id);
    void deleteById(Long id);
    List<Person> findAll();
}
