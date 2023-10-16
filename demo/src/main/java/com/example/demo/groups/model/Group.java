package com.example.demo.groups.model;


import com.example.demo.person.model.Person;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "groups")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;

    private String name;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Person> person;

    public Group(){}

    public Group(int id, String name, Set<Person> person) {
        this.id = id;
        this.name = name;
        this.person = person ;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Person> getMembers() {
        return person;
    }

    public void addMember(Person member) {
        this.person.add(member);
    }

    public void removeMember(Person member) {
        this.person.remove(member);
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", members=" + person +
                '}';
    }
}

