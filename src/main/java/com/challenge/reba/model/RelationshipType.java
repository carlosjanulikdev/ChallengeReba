package com.challenge.reba.model;

import com.challenge.reba.exception.RelationshipTypeNotFoundException;

import java.util.Arrays;

public enum RelationshipType {

    PADRE("PADRE"),
    HERMANO("HERMAN@"),
    PRIMO("PRIM@"),
    TIO("TI@");

    public final String description;

    private RelationshipType(String description){
        this.description = description;
    }

    public static RelationshipType findByDescription(String description) {
        return Arrays.stream(RelationshipType.values())
                .filter(e -> e.name().equals(description))
                .findFirst()
                .orElseThrow(() -> new RelationshipTypeNotFoundException(String.format("Tipo de relación '%s' no disponible", description)));
    }
}
