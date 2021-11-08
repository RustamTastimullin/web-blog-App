package ru.springapp.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/moreProjects")
    public String moreProjects(Model model) {
        model.addAttribute("title", "Other projects!");
        return "moreProjects";
    }

    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute( "title", "About!");
        return "about";
    }



}