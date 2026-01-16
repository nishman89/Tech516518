package com.sparta.todo.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
@RequestMapping("/") // Specifies all endpoints for this controller start with /todos
public class HomeController {

    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("EEEE d MMMM yyyy");

    @GetMapping("/")
    public String index(Model model) {
        String now = LocalDateTime.now().format(FORMATTER);
        model.addAttribute("date", now);
        return "index"; // looks for src/main/resources/templates/index.html
    }
}