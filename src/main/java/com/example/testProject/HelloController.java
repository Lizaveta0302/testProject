package com.example.testProject;

import com.example.testProject.entity.Message;
import com.example.testProject.repos.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    @Autowired
    private MessageRepo messageRepo;

    @GetMapping("/hello")
    public String hello(@RequestParam(name = "name", required = false, defaultValue = "World") String name,
                        Model model) {
        model.addAttribute("name", name);
        return "hello";
    }

    @GetMapping
    public String main(Model model) {
        Iterable<Message> messages = messageRepo.findAll();
        model.addAttribute("message", messages);
        return "hello";
    }

    @PostMapping
    public String addMessage(@RequestParam String text,
                             @RequestParam String tag,
                             Model model) {
        Message message = new Message(text, tag);
        messageRepo.save(message);
        Iterable<Message> messages = messageRepo.findAll();
        model.addAttribute("message", messages);

        return "hello";
    }

}
