package com.example.testProject.mvc;

import com.example.testProject.entity.*;
import com.example.testProject.entity.dto.MessageDto;
import com.example.testProject.repos.*;
import com.example.testProject.service.HikeService;
import com.example.testProject.service.MessageService;
import com.example.testProject.service.UserService;
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
import java.util.*;

@Controller
public class HikeController {

    @Autowired
    private HikeService hikeService;

    @Autowired
    private TypeHikeRepo typeHikeRepo;

    @Autowired
    private HikeRepo hikeRepo;

    @Autowired
    private SupervisorRepo supervisorRepo;

    @Autowired
    private UserService userService;

    @Autowired
    private DistributionSupervisorRepo distributionSupervisorRepo;


    @GetMapping("/hikes")
    public String hikes(@AuthenticationPrincipal User currentUser, Model model) {

        Iterable<Hike> hikes = hikeService.hikeList();
        if (currentUser == null) {
            model.addAttribute("reserves", " ");
        } else {
            List<Hike> hks = new ArrayList<>();
            List<Hike> hks_not_reserve = new ArrayList<>();
            List<Hike> res = currentUser.getReservations();
            for (Hike hk : hikes) {
                for (Hike h : res) {
                    if (h.getHike_id().equals(hk.getHike_id())) {
                        hks.add(hk);
                    }
                    else {
                        hks_not_reserve.add(hk);
                    }
                }
            }
            model.addAttribute("reserves", currentUser.getReservations());
            model.addAttribute("hikesNotReserve", hks_not_reserve);
        }
        model.addAttribute("hikes", hikes);
        return "hikes";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/hike/clear/{hike}")
    public String clearHike(
            @PathVariable Long hike
    ) {
        hikeRepo.deleteById(hike);
        return "redirect:/hikes";
    }

    @GetMapping("/hike/reservation/{hike}")
    public String reserveHike(
            @PathVariable Hike hike,
            @AuthenticationPrincipal User currentUser,
            Model model
    ) {
        model.addAttribute("isReserve", currentUser.getReservations().contains(hike));
        userService.reserve(hike, currentUser);
        return "redirect:/hikes";
    }

    @GetMapping("/hike/cancelReservation/{hike}")
    public String cancelReserveHike(
            @PathVariable Hike hike,
            @AuthenticationPrincipal User currentUser,
            Model model
    ) {
        userService.cancel_reserve(hike, currentUser);
        return "redirect:/main";
    }


    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/addHike")
    public String addHike(
            @RequestParam String name,
            @RequestParam Long price,
            @RequestParam String description,
            @RequestParam Long seats,
            @RequestParam String type_hike,
            @RequestParam String supervisorSelect
    ) {

        TypeHike typeHike = new TypeHike(type_hike);
        TypeHike typeHike1 = typeHikeRepo.save(typeHike);
        if (typeHike1 != null && !StringUtils.isEmpty(supervisorSelect)) {
            Hike hike = hikeService.save(new Hike(name, price, description, seats, typeHike));
            Long id = Long.valueOf(supervisorSelect);
            Optional<Supervisor> supervisor = supervisorRepo.findById(id);
            DistributionSupervisor distributionSupervisor = new DistributionSupervisor(hike, supervisor.get());
            distributionSupervisorRepo.save(distributionSupervisor);
        }
        return "redirect:/hikes";
    }

}