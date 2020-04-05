package com.example.testProject.repos;

import com.example.testProject.entity.FileModel;
import com.example.testProject.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface FileRepository extends JpaRepository<FileModel, Long> {
    FileModel findByName(String name);
}
