package com.challenge.reba.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Data
@Table(name="relationship")
public class Relationship {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="person_id_1", nullable=false)
    private Person person1;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="person_id_2", nullable=false)
    private Person person2;

    @Column(name = "type")
    private String type;

    public Relationship() {
    }

    public Relationship(Person person1, Person person2, String type) {
        this.person1 = person1;
        this.person2 = person2;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Relationship{" +
                "id=" + id +
                ", person1=" + person1 +
                ", person2=" + person2 +
                ", type=" + type +
                '}';
    }
}
