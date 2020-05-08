package com.example.testProject.repos;

import com.example.testProject.entity.Message;
import com.example.testProject.entity.Supervisor;
import com.example.testProject.entity.User;
import com.example.testProject.entity.dto.MessageDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SupervisorRepo extends CrudRepository<Supervisor, Long> {

}
