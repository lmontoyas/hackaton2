package com.example.demo.groups.controller;

import com.example.demo.groups.model.Group;
import com.example.demo.groups.repository.GroupRepository;
import com.example.demo.person.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/group")
public class GroupController {

    @Autowired
    private GroupRepository groupRepository;

    @GetMapping
    public ResponseEntity<List<Group>> groups() {
        List<Group> groups = groupRepository.findAll();
        return new ResponseEntity<>(groups, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Group> uniqueGrade(@PathVariable("id") Long id) {
        Optional<Group> findGrade = groupRepository.findById(id);
        if (findGrade.isPresent()) {
            return ResponseEntity.ok(findGrade.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/person/{groupId}")
    public Set<Person> getGroupByGroupId(@PathVariable Long groupId) {
        Group grupo = groupRepository.findById(groupId).orElse(null);

        if (grupo != null) {
            return grupo.getMembers();
        } else {
            return null;
        }
    }
}
