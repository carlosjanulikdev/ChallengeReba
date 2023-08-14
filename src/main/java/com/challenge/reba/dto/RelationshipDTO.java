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
}
