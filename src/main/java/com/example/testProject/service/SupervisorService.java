package com.example.testProject.service;

import com.example.testProject.entity.Supervisor;
import com.example.testProject.repos.SupervisorRepo;
import net.bytebuddy.implementation.bind.annotation.Super;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupervisorService {
    @Autowired
    private SupervisorRepo supervisorRepo;

    public Iterable<Supervisor> supervisorList() {
        return supervisorRepo.findAll();
    }

    public Supervisor save(Supervisor supervisor) {
         return supervisorRepo.save(supervisor);
    }

    public Supervisor getByName(String name){
        return supervisorRepo.findByName(name);
    }
}
