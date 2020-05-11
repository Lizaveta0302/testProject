package com.example.testProject.repos;

import com.example.testProject.entity.DistributionSupervisor;
import com.example.testProject.entity.Hike;
import com.example.testProject.entity.Supervisor;
import org.springframework.data.repository.CrudRepository;

public interface DistributionSupervisorRepo extends CrudRepository<DistributionSupervisor, Long> {

    DistributionSupervisor findBySupervisor(Supervisor supervisor);
}
