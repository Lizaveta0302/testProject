package com.example.testProject.mvc;

import com.example.testProject.entity.FileModel;
import com.example.testProject.entity.Message;
import com.example.testProject.entity.User;
import com.example.testProject.entity.dto.MessageDto;
import com.example.testProject.repos.FileRepository;
import com.example.testProject.repos.MessageRepo;
import com.example.testProject.repos.UserRepo;
import com.example.testProject.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

@Controller
public class HikeController {

    @Autowired
    private MessageRepo messageRepo;


    @GetMapping("/hikes")
    public String hikes(Model model) {

        Iterable<Message> messages = messageRepo.findAll();
        model.addAttribute("messages", messages);
        return "hikes";
    }

}