package com.example.testProject.mvc;

import com.example.testProject.entity.FileModel;
import com.example.testProject.entity.Message;
import com.example.testProject.entity.User;
import com.example.testProject.repos.FileRepository;
import com.example.testProject.repos.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StreamUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Map;
import java.util.Optional;
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
                    /*.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getName() + "\"")
                    .body(file.getPic());*/
        }
        return ResponseEntity.status(404).body(null);
    }

   /* @GetMapping(value = "img/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
    public void fromDatabaseAsHttpServResp(@PathVariable("id") Long id, HttpServletResponse response)
            throws SQLException, IOException {

        Optional<FileModel> fileModelOptional = fileRepository.findById(id);

        if (fileModelOptional.isPresent()) {

            byte[] image = fileModelOptional.get().getPic();

            StreamUtils.copy(image, response.getOutputStream());
        }
    }*/

}