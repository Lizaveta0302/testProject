package com.example.testProject.service;

import com.example.testProject.entity.Hike;
import com.example.testProject.entity.Supervisor;
import com.example.testProject.repos.HikeRepo;
import com.example.testProject.repos.SupervisorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HikeService {
    @Autowired
    private HikeRepo hikeRepo;

    public Iterable<Hike> hikeList() {
        return hikeRepo.findAll();
    }

    public void save(Hike hike) {
         hikeRepo.save(hike);
    }

    public Hike getByName(String name){
        return hikeRepo.findByName(name);
    }
}
