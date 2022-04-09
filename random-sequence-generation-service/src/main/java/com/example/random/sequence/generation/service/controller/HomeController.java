package com.example.random.sequence.generation.service.controller;

import com.example.random.sequence.generation.service.handler.WebSocketHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    private static final Logger log = LoggerFactory.getLogger(HomeController.class);

    @GetMapping("/home")
    public String home(@RequestParam(required = false) String length, Model model) {
        log.info("ENTERED ARRAY LENGTH: " + length);
        model.addAttribute("length", length);
        return "home_page";
    }
}