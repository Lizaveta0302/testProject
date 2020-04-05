package com.example.testProject.mvc;

import com.example.testProject.entity.FileModel;
import com.example.testProject.entity.Message;
import com.example.testProject.entity.User;
import com.example.testProject.repos.FileRepository;
import com.example.testProject.repos.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

@Controller
public class MainController {

    @Autowired
    private MessageRepo messageRepo;

    @Autowired
    FileRepository fileRepository;

    @GetMapping("/")
    public String home(Map<String, Object> model) {
        return "home";
    }

    @GetMapping("/main")
    public String main(@RequestParam(required = false, defaultValue = "") String filter, Model model) {
        Iterable<Message> messages = messageRepo.findAll();

        if (filter != null && !filter.isEmpty()) {
            messages = messageRepo.findByTag(filter);
        } else {
            messages = messageRepo.findAll();
        }

        model.addAttribute("messages", messages);
        model.addAttribute("filter", filter);

        return "main";
    }

    @PostMapping("/main")
    public String add(
            @AuthenticationPrincipal User user,
            @Valid Message message,
            BindingResult bindingResult,
            Model model,
            @RequestParam("uploadfile") MultipartFile file
    ) throws IOException {

        if (bindingResult.hasErrors()) {
            Map<String, String> errorsMap = ControllerUtils.getErrors(bindingResult);
            model.addAttribute("message", message);
            model.mergeAttributes(errorsMap);
        } else {
            if (file != null && !file.getOriginalFilename().isEmpty()) {

                FileModel fileModel = new FileModel(file.getOriginalFilename(), file.getContentType(), file.getBytes());
                fileRepository.save(fileModel);
                message.setAuthor(user);
                message.setFile(fileModel);
                //fileModel.setMessage(message);
            }
            model.addAttribute("message", null);
            messageRepo.save(message);
        }
        Iterable<Message> messages = messageRepo.findAll();

        model.addAttribute("messages", messages);

        return "redirect:/main";
    }
}