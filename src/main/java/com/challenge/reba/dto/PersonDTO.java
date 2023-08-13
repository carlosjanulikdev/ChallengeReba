package com.challenge.reba.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PersonDTO {

    @Column(name="document_type_id")
    @NotNull(message = "El id de tipo de documento es obligatorio")
    private Long documentTypeId;

    @Column(name="document_number")
    @NotNull(message = "El numero de documento es obligatorio")
    private Long documentNumber;

    @Column(name="country_id")
    @NotNull(message = "El id de pais es obligatorio")
    private Long countryId;

    @Column(name="phone")
    private String phone;

    @Column(name="email")
    @Email
    private String email;

    @Column(name="age")
    @Min(value = 18, message = "No pueden crearse personas menores de 18 años")
    @NotNull(message = "La edad es obligatoria")
    private Integer age;

}
