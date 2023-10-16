package com.example.demo.groups.repository;

import com.example.demo.groups.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group,Long> {
}
