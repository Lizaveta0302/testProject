package com.example.testProject.repos;

import com.example.testProject.entity.Supervisor;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface SupervisorRepo extends CrudRepository<Supervisor, Long> {

    Supervisor findByName(String name);
    Optional<Supervisor> findById(Long id);

}
