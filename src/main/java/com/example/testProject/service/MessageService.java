package com.example.testProject.service;

import com.example.testProject.entity.Message;
import com.example.testProject.entity.User;
import com.example.testProject.entity.dto.MessageDto;
import com.example.testProject.repos.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
    @Autowired
    private MessageRepo messageRepo;

    public Iterable<MessageDto> messageList(String filter, User user) {
        if (filter != null && !filter.isEmpty()) {
            return messageRepo.findByTag(filter, user);
        } else {
            return messageRepo.findAll(user);
        }
    }

    public Iterable<MessageDto> messageListForUser(User currentUser, User author) {
        return messageRepo.findByUser(author, currentUser);
    }
}
