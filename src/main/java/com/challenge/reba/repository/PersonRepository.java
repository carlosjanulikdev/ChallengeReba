package com.challenge.reba.repository;

import com.challenge.reba.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

    Optional<Person> findByDocumentTypeIdAndDocumentNumberAndCountryId(Long documentTypeId, Long documentNumber, Long countryId);
}
