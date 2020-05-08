package com.example.testProject.mvc;

import com.example.testProject.entity.Message;
import com.example.testProject.entity.Supervisor;
import com.example.testProject.repos.MessageRepo;
import com.example.testProject.service.SupervisorService;
import net.bytebuddy.implementation.bind.annotation.Super;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SupervisorController {

    @Autowired
    private SupervisorService supervisorService;


    @GetMapping("/hikes")
    public String supervisor(Model model) {

        Iterable<Supervisor> supervisors = supervisorService.supervisorList();
        model.addAttribute("supervisors", supervisors);
        return "hikes";
    }

    //@PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/hikes")
    public String addSupervisor(
            @RequestParam String name,
            @RequestParam String last_name,
            @RequestParam String patronymic,
            @RequestParam String phone,
            @RequestParam String city
    ) {

        supervisorService.save(new Supervisor(name, last_name, patronymic, phone, city));

        return "redirect:/hikes";
    }


}