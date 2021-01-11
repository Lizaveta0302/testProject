package com.example.testProject.service;

import com.example.testProject.entity.DistributionSupervisor;
import com.example.testProject.entity.Hike;
import com.example.testProject.entity.Supervisor;

import java.util.Optional;

public interface HikeService {

    Hike save(Hike hike);

    void deleteById(Long id);

    Hike getByName(String name);

    Optional<Hike> getById(Long id);

    DistributionSupervisor findBySupervisor(Supervisor supervisor);

}
