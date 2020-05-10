package com.example.testProject.repos;

import com.example.testProject.entity.Hike;
import com.example.testProject.entity.Supervisor;
import org.springframework.data.repository.CrudRepository;

public interface HikeRepo extends CrudRepository<Hike, Long> {

    Hike findByName(String name);

}
