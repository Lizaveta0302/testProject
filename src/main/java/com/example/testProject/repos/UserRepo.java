package com.example.testProject.repos;

import com.example.testProject.entity.Message;
import com.example.testProject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepo extends JpaRepository<User, Long> {
User findByUsername(String username);
}
