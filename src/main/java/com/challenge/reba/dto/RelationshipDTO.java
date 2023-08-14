package com.challenge.reba.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RelationshipDTO {

    @Column(name="id1")
    @NotNull(message = "El id1 es obligatorio")
    private Long id1;

    @Column(name="id2")
    @NotNull(message = "El id2 es obligatorio")
    private Long id2;

    @Column(name="type")
    private String type;

    public RelationshipDTO(){

    }

    public RelationshipDTO(Long id1, Long id2, String type) {
        this.id1 = id1;
        this.id2 = id2;
        this.type = type;
    }
}
