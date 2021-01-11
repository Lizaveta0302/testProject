package com.example.testProject.service;

import com.example.testProject.entity.Supervisor;

import java.util.Optional;

public interface SupervisorService {

    Iterable<Supervisor> supervisorList();

    Supervisor save(Supervisor supervisor);

    Supervisor getByName(String name);

    Optional<Supervisor> getById(Long id);

    void deleteById(Long id);
}
