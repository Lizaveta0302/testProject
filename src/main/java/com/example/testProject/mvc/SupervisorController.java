package com.example.testProject.mvc;

import com.example.testProject.entity.Hike;
import com.example.testProject.entity.Supervisor;
import com.example.testProject.entity.User;
import com.example.testProject.service.SupervisorServiceImpl;
import com.example.testProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.ArrayList;

@Controller
public class SupervisorController {

    @Autowired
    private SupervisorServiceImpl supervisorService;

    @Autowired
    private UserService userService;

    @GetMapping("/supervisors")
    public String supervisors(Model model) {

        Iterable<Supervisor> supervisors = supervisorService.supervisorList();
        Iterable<User> users = userService.findAll();
        model.addAttribute("users", users);
        ArrayList<Hike> countHikes = new ArrayList<>();
        /*for (Supervisor sup : supervisors) {
            Hike hike = distributionSupervisorRepo.findBySupervisor(sup).getHike();
            if (hike != null) {
                countHikes.add(hike);
            }
        }*/
        model.addAttribute("hikesCount", countHikes);
        model.addAttribute("supervisors", supervisors);
        return "supervisors";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/supervisor/clear/{supervisor}")
    public String clearSupervisor(
            @PathVariable Long supervisor
    ) {
        supervisorService.deleteById(supervisor);
        return "redirect:/supervisors";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/addSupervisor")
    public String addSupervisor(
            @RequestParam String name,
            @RequestParam String last_name,
            @RequestParam String patronymic,
            @RequestParam String phone,
            @RequestParam String city,
            @Valid User user
    ) {

        User user1 = userService.getByname(user.getUsername());
        if (user1 == null) {
            Supervisor supervisor = supervisorService.save(new Supervisor(name, last_name, patronymic, phone, city));
            //получить по имени руководителя взять у него id и установить для User
            user.setSupervisor(supervisor);
            userService.addUser(user);
        }
        return "redirect:/supervisors";
    }


}