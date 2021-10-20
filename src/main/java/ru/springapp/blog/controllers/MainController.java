package ru.springapp.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/moreProjects")
    public String moreProjects(Model model) {
        model.addAttribute("title", "Greeting page!");
        return "moreProjects";
    }
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute( "title", "Главная страница!");
        return "blogAppTemplates/blog-main";
    }
    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute( "title", "Страница обо мне!");
        return "about";
    }

}