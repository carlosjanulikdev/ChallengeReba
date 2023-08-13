package com.challenge.reba.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Data
@Table(name="person")
public class Person {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="document_type_id", nullable=false)
    private DocumentType documentType;

    @Column(name="document_number")
    private Long documentNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="country_id", nullable=false)
    private Country country;

    @Column(name="phone")
    private String phone;

    @Column(name="email")
    private String email;

    @Column(name="age")
    @Min(value = 18, message = "No pueden crearse personas menores de 18 años")
    private int age;

}
