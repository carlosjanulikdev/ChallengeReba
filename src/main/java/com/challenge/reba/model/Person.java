package com.challenge.reba.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
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
    @NotNull(message = "El numero de documento es obligatorio")
    private Long documentNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="country_id", nullable=false)
    private Country country;

    @Column(name="full_name")
    private String fullName;

    @Column(name="phone")
    private String phone;

    @Column(name="email")
    @Email
    private String email;

    @Column(name="age")
    @Min(value = 18, message = "No pueden crearse personas menores de 18 años")
    private int age;

    public Person(){

    }

    public Person(Long documentNumber, String fullName, String phone, String email, int age) {
        this.documentNumber = documentNumber;
        this.fullName = fullName;
        this.phone = phone;
        this.email = email;
        this.age = age;
    }
}
