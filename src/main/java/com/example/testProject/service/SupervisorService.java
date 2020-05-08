package com.example.testProject.service;

import com.example.testProject.entity.Supervisor;
import com.example.testProject.repos.SupervisorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupervisorService {
    @Autowired
    private SupervisorRepo supervisorRepo;

    public Iterable<Supervisor> supervisorList() {
        return supervisorRepo.findAll();
    }

    public void save(Supervisor supervisor) {
         supervisorRepo.save(supervisor);
    }
}
