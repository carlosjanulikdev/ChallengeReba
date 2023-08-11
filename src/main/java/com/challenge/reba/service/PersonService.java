package com.challenge.reba.service;

import com.challenge.reba.model.Person;
import com.challenge.reba.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService implements IPersonService {

    @Autowired
    private PersonRepository personRepository;

    public Person create(Person person){
        return personRepository.save(person);
    }

    public Person findById(Long id){
        return personRepository.findById(id).get();
    }

    public void deleteById(Long id){
        personRepository.deleteById(id);
    }

    public List<Person> findAll(){
        return (List<Person>) personRepository.findAll();
    }
}
