package com.example.testProject.service;

import com.example.testProject.entity.Supervisor;
import com.example.testProject.repos.SupervisorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SupervisorServiceImpl implements SupervisorService {
    @Autowired
    private SupervisorRepo supervisorRepo;

    @Override
    public Iterable<Supervisor> supervisorList() {
        return supervisorRepo.findAll();
    }

    @Override
    public Supervisor save(Supervisor supervisor) {
        return supervisorRepo.save(supervisor);
    }

    @Override
    public Supervisor getByName(String name) {
        return supervisorRepo.findByName(name);
    }

    @Override
    public Optional<Supervisor> getById(Long id) {
        return supervisorRepo.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        supervisorRepo.deleteById(id);
    }
}
