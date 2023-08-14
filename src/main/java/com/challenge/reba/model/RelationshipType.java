package com.challenge.reba.model;

public enum RelationshipType {
    HERMANO("HERMAN@"),
    PRIMO("PRIM@"),
    TIO("TI@");

    public final String description;

    private RelationshipType(String description){
        this.description = description;
    }
}
