package com.example.random.sequence.generation.service.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GeneratePageController {

    @GetMapping("/generate")
    public String generate() {
        return "generate_page";
    }
}
