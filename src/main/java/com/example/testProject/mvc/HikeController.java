package com.example.testProject.mvc;

import com.example.testProject.entity.*;
import com.example.testProject.entity.dto.MessageDto;
import com.example.testProject.repos.FileRepository;
import com.example.testProject.repos.MessageRepo;
import com.example.testProject.repos.TypeHikeRepo;
import com.example.testProject.repos.UserRepo;
import com.example.testProject.service.HikeService;
import com.example.testProject.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
    private HikeService hikeService;

    @Autowired
    private TypeHikeRepo typeHikeRepo;


    @GetMapping("/hikes")
    public String hikes(Model model) {

        Iterable<Hike> hikes = hikeService.hikeList();
        model.addAttribute("hikes", hikes);
        return "hikes";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/addHike")
    public String addHike(
            @RequestParam String name,
            @RequestParam Long price,
            @RequestParam String description,
            @RequestParam Long seats,
            @RequestParam String type_hike
    ) {

        TypeHike typeHike = new TypeHike(type_hike);
        TypeHike typeHike1 = typeHikeRepo.save(typeHike);
        if (typeHike1 != null) {
            hikeService.save(new Hike(name, price, description, seats, typeHike));
        }
        return "redirect:/hikes";
    }

}