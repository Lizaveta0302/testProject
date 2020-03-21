package com.example.testProject;

import com.example.testProject.entity.Message;
import com.example.testProject.repos.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class HelloController {

    @Autowired
    private MessageRepo messageRepo;

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
        return "redirect:";
    }

    @PostMapping("filter")
    public String filterMessage(@RequestParam String filter,
                                Model model) {
        Iterable<Message> filtered;
        if (filter != null && !filter.isEmpty()) {
            filtered = messageRepo.findByTag(filter);
        } else {
            filtered = messageRepo.findAll();
        }
        model.addAttribute("message", filtered);
        return "hello";
    }

}
