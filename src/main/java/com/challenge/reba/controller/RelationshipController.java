package com.challenge.reba.controller;

import com.challenge.reba.dto.RelationshipDTO;
import com.challenge.reba.model.Relationship;
import com.challenge.reba.service.IRelationshipService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/relaciones")
public class RelationshipController {
    Logger logger = LoggerFactory.getLogger(RelationshipController.class);

    @Autowired
    private IRelationshipService relationshipService;

    /**
     *
     * @param id1: personId1
     * @param id2: personId2
     * @return a relationship between persons with id1 and id2
     */
    @GetMapping(value = "/{id1}/{id2}")
    public Relationship findRelationShip(@PathVariable(required = true) Long id1,
                                         @PathVariable(required = true) Long id2){
        logger.info("id1:{} - id2:{}", id1, id2);

        return relationshipService.findByPerson1IdAndPerson2Id(id1, id2);
    }

    @PostMapping(value = "/{id1}/{type}/{id2}")
    public ResponseEntity<Relationship> create(@PathVariable(required = true) Long id1,
                                               @PathVariable(required = true) String type,
                                               @PathVariable(required = true) Long id2){
        RelationshipDTO relationshipDTO = new RelationshipDTO(id1, id2, type.toUpperCase());

        logger.info("Create relationship:{}", relationshipDTO);
        Relationship newRelationship = relationshipService.create(relationshipDTO);

        return new ResponseEntity<>(newRelationship, HttpStatus.CREATED);
    }

}
