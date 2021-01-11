package com.example.testProject.service;

import com.example.testProject.entity.DistributionSupervisor;
import com.example.testProject.entity.Hike;
import com.example.testProject.entity.Supervisor;
import com.example.testProject.entity.TypeHike;
import com.example.testProject.repos.DistributionSupervisorRepo;
import com.example.testProject.repos.HikeRepo;
import com.example.testProject.repos.TypeHikeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HikeServiceImpl implements HikeService {

    @Autowired
    private HikeRepo hikeRepo;

    @Autowired
    private TypeHikeRepo typeHikeRepo;

    @Autowired
    private DistributionSupervisorRepo distributionSupervisorRepo;

    public Iterable<Hike> hikeList() {
        return hikeRepo.findAll();
    }

    @Override
    public Hike save(Hike hike) {
        return hikeRepo.save(hike);
    }

    @Override
    public void deleteById(Long id) {
        hikeRepo.deleteById(id);
    }

    @Override
    public Hike getByName(String name) {
        return hikeRepo.findByName(name);
    }

    @Override
    public Optional<Hike> getById(Long id) {
        return hikeRepo.findById(id);
    }

    @Override
    public DistributionSupervisor findBySupervisor(Supervisor supervisor) {
        return distributionSupervisorRepo.findBySupervisor(supervisor);
    }

    public TypeHike saveTypeHike(TypeHike typeHike) {
        return typeHikeRepo.save(typeHike);
    }

    public DistributionSupervisor saveDistributionSupervisor(DistributionSupervisor distributionSupervisor) {
        return distributionSupervisorRepo.save(distributionSupervisor);
    }
}
