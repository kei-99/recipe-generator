package com.example.step13.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/recipe")
    public String showRecipePage(Model model) {
        return "index";  // templates/index.html を返す
    }
}
