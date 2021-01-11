package com.example.testProject.mvc;

import com.example.testProject.entity.FileModel;
import com.example.testProject.entity.Role;
import com.example.testProject.entity.Supervisor;
import com.example.testProject.entity.User;
import com.example.testProject.repos.FileRepository;
import com.example.testProject.service.HikeService;
import com.example.testProject.service.SupervisorService;
import com.example.testProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private SupervisorService supervisorService;

    @Autowired
    private HikeService hikeService;

    @Autowired
    private FileRepository fileRepository;

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    public String userList(Model model) {
        model.addAttribute("users", userService.findAll());
        return "userList";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("{user}")
    public String userEditForm(@PathVariable User user, Model model) {
        model.addAttribute("user", user);
        model.addAttribute("roles", Role.values());
        return "userEdit";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public String userSave(
            @RequestParam String username,
            @RequestParam Map<String, String> form,
            @RequestParam("userId") User user) {
        User user1 = userService.getByname(username);

        if (user1 == null && !StringUtils.isEmpty(username)) {
            userService.saveUser(user, username, form);
        }
        return "redirect:/user";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("delete/{user}")
    public String userDelete(
            @PathVariable Long user,
            Model model) {
        User user1 = userService.getById(user).get();

        if (user1.getSupervisor() != null) {
            Supervisor supervisor = user1.getSupervisor();
            if (hikeService.findBySupervisor(supervisor) != null) {
                model.addAttribute("errorDelete", "У данного пользователя запланированы походы, Вы не можете его удалить!");
            } else {
                userService.userDelete(user);
                supervisorService.deleteById(supervisor.getSupervisor_id());
            }
        } else {
            userService.userDelete(user);
        }
        return "redirect:/user";
    }

    @GetMapping("profile")
    public String getProfile(Model model, @AuthenticationPrincipal User user) {
        model.addAttribute("username", user.getUsername());
        //model.addAttribute("email", user.getEmail());
        return "profile";
    }

    @PostMapping("profile")
    public String updateProfile(
            /*@RequestParam String email,*/
            @RequestParam String password,
            @AuthenticationPrincipal User user,
            @RequestParam("uploadfile") MultipartFile file) throws IOException {

        if (file != null && !file.getOriginalFilename().isEmpty()) {
            FileModel fileModel = new FileModel(file.getOriginalFilename(), file.getContentType(), file.getBytes());

            fileRepository.save(fileModel);
            user.setFile(fileModel);
        }
        userService.updateProfile(/*email,*/password, user);
        return "redirect:/user/private-cabinet";
    }

    @GetMapping("subscribe/{user}")
    public String subscribe(
            @AuthenticationPrincipal User currentUser,
            @PathVariable User user
    ) {
        userService.subscribe(currentUser, user);
        return "redirect:/user-messages/" + user.getId();
    }

    @GetMapping("unsubscribe/{user}")
    public String unsubscribe(
            @PathVariable User user,
            @AuthenticationPrincipal User currentUser
    ) {
        userService.unsubscribe(currentUser, user);
        return "redirect:/user-messages/" + user.getId();
    }

    @GetMapping("{type}/{user}/list")
    public String userList(Model model,
                           @PathVariable User user,
                           @PathVariable String type) {
        model.addAttribute("userChannel", user);
        model.addAttribute("type", type);

        if ("subscriptions".equals(type)) {
            model.addAttribute("users", user.getSubscriptions());
        } else {
            model.addAttribute("users", user.getSubscribers());
        }

        return "subscriptions";
    }

    @GetMapping("reservations/{user}/list")
    public String userList(Model model,
                           @PathVariable User user) {

        model.addAttribute("userChannel", user);

        model.addAttribute("reservations", user.getReservations());

        return "reservations";
    }

    @GetMapping("/private-cabinet")
    public String privateCabinet(
            @AuthenticationPrincipal User user,
            Model model
    ) {
        User user1 = (User) userService.loadUserByUsername(user.getUsername());
        model.addAttribute("user", user);
        model.addAttribute("countMessages", user1.getMessages().size());
        model.addAttribute("followers", user1.getSubscribers().size());
        model.addAttribute("following", user1.getSubscriptions().size());

        return "privateCabinet";
    }

}
