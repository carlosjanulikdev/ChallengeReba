package com.challenge.reba.service;

import com.challenge.reba.dto.RelationshipDTO;
import com.challenge.reba.model.Relationship;

public interface IRelationshipService {

    Relationship create(RelationshipDTO relationshipDTO);
    Relationship findByPerson1IdAndPerson2Id(Long id1, Long id2);
}
