package com.example.random.sequence.generation.service.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GeneratePageController {
    private static final Logger log = LoggerFactory.getLogger(GeneratePageController.class);


    @GetMapping("/generate")
    public String generate() {
        return "generate_page";
    }
}
