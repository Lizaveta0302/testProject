package com.example.testProject.service;

import com.example.testProject.entity.Hike;
import com.example.testProject.repos.HikeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HikeService {
    @Autowired
    private HikeRepo hikeRepo;

    public Iterable<Hike> hikeList() {
        return hikeRepo.findAll();
    }

    public Hike save(Hike hike) {
         return hikeRepo.save(hike);
    }

    public Hike getByName(String name){
        return hikeRepo.findByName(name);
    }

    public Optional<Hike> getById(Long id){
        return hikeRepo.findById(id);
    }
}
