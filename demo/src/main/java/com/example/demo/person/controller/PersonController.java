package com.example.demo.person.controller;

import com.example.demo.groups.model.Group;
import com.example.demo.person.model.Person;
import com.example.demo.person.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonRepository personRepository;

    // hacer inyeccion de dependencia de GROUps

    @GetMapping
    public ResponseEntity <List<Person>> Person(){
        List<Person> person = personRepository.findAll();
        return ResponseEntity.ok(person);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable Long id){
        Optional<Person> person_ob = personRepository.findById(id);
        if(person_ob.isPresent()){
            return ResponseEntity.ok(person_ob.get());
        }
        else {
            return (ResponseEntity<Person>) ResponseEntity.badRequest();
        }
    }

    @GetMapping("/group/{personId}")
    public Set<Group> getGroupByPersonId(@PathVariable Long personId) {
        Person person = personRepository.findById(personId).orElse(null);

        if (person != null) {
            return person.getGrupos();
        } else {
            return null;
        }
    }
}