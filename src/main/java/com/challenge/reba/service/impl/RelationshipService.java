package com.challenge.reba.service.impl;

import com.challenge.reba.dto.RelationshipDTO;
import com.challenge.reba.exception.DocumentTypeNotFoundException;
import com.challenge.reba.exception.RelationshipExistingException;
import com.challenge.reba.model.Person;
import com.challenge.reba.model.Relationship;
import com.challenge.reba.model.RelationshipType;
import com.challenge.reba.repository.PersonRepository;
import com.challenge.reba.repository.RelationshipRepository;
import com.challenge.reba.service.IRelationshipService;
import com.challenge.reba.utils.Constants;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RelationshipService implements IRelationshipService {

    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private RelationshipRepository relationshipRepository;

    @SneakyThrows
    public Relationship create(RelationshipDTO relationshipDTO) {

        Person person1 = personRepository.findById(relationshipDTO.getId1())
                            .orElseThrow(() ->
                                    new DocumentTypeNotFoundException("No existe la persona con id: "+relationshipDTO.getId1()));

        Person person2 = personRepository.findById(relationshipDTO.getId2())
                .orElseThrow(() ->
                        new DocumentTypeNotFoundException("No existe la persona con id: "+relationshipDTO.getId2()));

        this.validateIfRelationshipExist(relationshipDTO.getId1(), relationshipDTO.getId2());

        Relationship relationship = new Relationship(person1, person2, RelationshipType.findByDescription(relationshipDTO.getType()).description);

        return relationshipRepository.save(relationship);
    }

    private void validateIfRelationshipExist(Long personId1, Long personId2) throws RelationshipExistingException {
        relationshipRepository.findByPerson1IdAndPerson2Id(personId1, personId2)
                .ifPresent( p -> {
                    throw new RelationshipExistingException(Constants.VALIDATION_MESSAGE_OO3);
                });
    }

    @Override
    public Relationship findByPerson1IdAndPerson2Id(Long id1, Long id2) {
        return relationshipRepository.findByPerson1IdAndPerson2Id(id1, id2).get();
    }

}
