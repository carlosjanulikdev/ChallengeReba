package com.challenge.reba.repository;

import com.challenge.reba.model.Relationship;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RelationshipRepository extends CrudRepository<Relationship, Long> {

    Optional<Relationship> findByPerson1IdAndPerson2Id(Long id1, Long id2);
}
