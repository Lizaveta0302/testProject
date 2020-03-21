package com.example.testProject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String hello(@RequestParam(name = "name", required = false, defaultValue = "World") String name,
                        Model model) {
        model.addAttribute("name", name);
        return "hello";
    }
    @GetMapping("/hello2")
    public String hello2(@RequestParam(name = "name", required = false, defaultValue = "World2") String name,
                        Model model) {
        model.addAttribute("name", name);
        return "hello2";
    }
    @GetMapping("/hello3")
    public String hello3(@RequestParam(name = "name", required = false, defaultValue = "World3") String name,
                        Model model) {
        model.addAttribute("name", name);
        return "hello3";
    }
}
