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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.io.IOException;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

@Controller
public class MainController {

    @Autowired
    private MessageRepo messageRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private MessageService messageService;

    @Autowired
    FileRepository fileRepository;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("home", "home");
        return "home";
    }

    @GetMapping("/main")
    public String main(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @AuthenticationPrincipal User user) {

        Iterable<MessageDto> messages = messageService.messageList(filter, user);

        model.addAttribute("messages", messages);
        model.addAttribute("filter", filter);

        return "main";
    }

    @GetMapping("/info")
    public String info(Model model) {
        User admin = userRepo.findByUsername("admin");
        model.addAttribute("admin", admin);
        return "info";
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
            saveFile(message, file);
            message.setAuthor(user);
            model.addAttribute("message", null);
            messageRepo.save(message);
        }
        Iterable<Message> messages = messageRepo.findAll();

        model.addAttribute("messages", messages);

        return "redirect:/main";
    }

    private void saveFile(@Valid Message message,
                          @RequestParam("uploadfile") MultipartFile file) throws IOException {
        if (file != null && !file.getOriginalFilename().isEmpty()) {
            FileModel fileModel = new FileModel(file.getOriginalFilename(), file.getContentType(), file.getBytes());
            fileRepository.save(fileModel);
            message.setFile(fileModel);
            //fileModel.setMessage(message);
        }
    }

    @ResponseBody
    @GetMapping("/api/file/{id}")
    public ResponseEntity<byte[]> getFile(@PathVariable Long id) {
        Optional<FileModel> fileOptional = fileRepository.findById(id);
        byte[] imageBytes = null;
        if (fileOptional.isPresent()) {
            //FileModel file = fileOptional.get();
            imageBytes = fileOptional.get().getPic();
            return ResponseEntity.ok()
                    .contentType(MediaType.IMAGE_JPEG).body(imageBytes);
                    /* for download file
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getName() + "\"")
                    .body(file.getPic());*/
        }
        return ResponseEntity.status(404).body(null);
    }


    @GetMapping("/user-messages/{user}")
    public String userMessages(
            @AuthenticationPrincipal User currentUser,
            @PathVariable User user,
            Model model,
            @RequestParam(required = false) Message message
    ) {

        //Set<Message> messages = user.getMessages();
        Iterable<MessageDto> messages = messageService.messageListForUser(currentUser, user);
        model.addAttribute("userChannel", user);
        model.addAttribute("subscriptionsCount", user.getSubscriptions().size());
        model.addAttribute("subscribersCount", user.getSubscribers().size());
        model.addAttribute("isSubscriber", user.getSubscribers().contains(currentUser));
        model.addAttribute("messages", messages);
        model.addAttribute("message", message);
        model.addAttribute("isCurrentUser", currentUser.equals(user));

        return "userMessages";
    }

    @PostMapping("/user-messages/{user}")
    public String updateMessage(
            @AuthenticationPrincipal User currentUser,
            @PathVariable User user,
            @RequestParam("id") Message message,
            @RequestParam("text") String text,
            @RequestParam("tag") String tag,
            @RequestParam("file") MultipartFile file) throws IOException {

        if (message.getAuthor().equals(currentUser)) {
            if (!StringUtils.isEmpty(text)) {
                message.setText(text);
            }
            if (!StringUtils.isEmpty(tag)) {
                message.setTag(tag);
            }
            saveFile(message, file);
            messageRepo.save(message);
        }
        return "redirect:/user-messages/" + user.getId();
    }

    @GetMapping("/messages/{message}/like")
    public String like(
            @AuthenticationPrincipal User currentUser,
            @PathVariable Message message
    ) {
        Set<User> likes = message.getLikes();

        if (likes.contains(currentUser)) {
            likes.remove(currentUser);
        } else {
            likes.add(currentUser);
        }
        messageRepo.save(message);
        return "redirect:/main";
    }

    @GetMapping("/user-messages/clear/{message}")
    public String clearMessage(
            @PathVariable Long message
    ) {
        messageRepo.deleteById(message);
        return "redirect:/main";
    }


    @GetMapping("/review/{message}")
    public String review(
            Model model,
            @AuthenticationPrincipal User user,
            @PathVariable Message message
    ) {

        Iterable<MessageDto> messages = messageService.messageList(message.getTag(),user);

        model.addAttribute("messageList", messages);
        model.addAttribute("message", message);

        return "review";
    }
}