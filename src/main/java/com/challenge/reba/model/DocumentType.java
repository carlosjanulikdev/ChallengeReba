package com.challenge.reba.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Data
@Table(name="document_type")
public class DocumentType {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private Long id;

    @Column(name="description")
    @NotNull(message = "La descripcion es obligatoria")
    private String description;

    @Override
    public String toString() {
        return "DocumentType{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }

}
