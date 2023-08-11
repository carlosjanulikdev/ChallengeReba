package com.challenge.reba.model;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Data
@Table(name="document_type")
public class DocumentType {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private Long id;

    @Column(name="description")
    private String description;

    @Override
    public String toString() {
        return "DocumentType{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }

}
