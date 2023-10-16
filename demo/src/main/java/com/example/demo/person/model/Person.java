package com.example.demo.person.model;

import com.example.demo.groups.model.Group;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "person")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Group>  grupos;

    public Person() {
    }

    public Person(Long id, String name, Set<Group> grupos) {
        this.name = name;
        this.grupos = grupos;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Group> getGrupos() {
        return grupos;
    }

    public void setGrupos(Set<Group> grupos) {
        this.grupos = grupos;
    }
}
