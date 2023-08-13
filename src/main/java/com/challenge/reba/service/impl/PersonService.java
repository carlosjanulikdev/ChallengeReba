package com.challenge.reba.service.impl;

import com.challenge.reba.dto.PersonDTO;
import com.challenge.reba.exception.ContactInformationNotFoundException;
import com.challenge.reba.exception.CountryNotFoundException;
import com.challenge.reba.exception.DocumentTypeNotFoundException;
import com.challenge.reba.model.Country;
import com.challenge.reba.model.DocumentType;
import com.challenge.reba.model.Person;
import com.challenge.reba.repository.CountryRepository;
import com.challenge.reba.repository.DocumentTypeRepository;
import com.challenge.reba.repository.PersonRepository;
import com.challenge.reba.service.IPersonService;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService implements IPersonService {

    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private CountryRepository countryRepository;
    @Autowired
    private DocumentTypeRepository documentTypeRepository;

    @SneakyThrows
    public Person create(PersonDTO personDTO) {
        //Validation that the person has at least one contact information
        if(StringUtils.isBlank(personDTO.getEmail()) && StringUtils.isBlank(personDTO.getPhone())){
            throw new ContactInformationNotFoundException("La persona debe tener al menos un dato de contacto.");
        }

        DocumentType documentType = null;
        Country country = null;
        Person person = new Person(personDTO.getDocumentNumber(),
                                   personDTO.getPhone(),
                                   personDTO.getEmail(),
                                   personDTO.getAge());

        documentType = documentTypeRepository.findById(personDTO.getDocumentTypeId())
                            .orElseThrow(() ->
                                    new DocumentTypeNotFoundException("No existe el tipo de documento con id: "+personDTO.getDocumentTypeId()));

        country = countryRepository.findById(personDTO.getCountryId())
                            .orElseThrow(() ->
                                    new CountryNotFoundException("No existe el pais con id: "+personDTO.getCountryId()));

        person.setDocumentType(documentType);
        person.setCountry(country);

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
