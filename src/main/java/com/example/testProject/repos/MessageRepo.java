package com.example.testProject.repos;

import com.example.testProject.entity.FileModel;
import com.example.testProject.entity.Message;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessageRepo extends CrudRepository<Message, Long> {
    List<Message> findByTag(String tag);
}
