package com.example.random.sequence.generation.service.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.LinkedList;
import java.util.List;

@Controller
public class AutoPageController {
    private static final Logger log = LoggerFactory.getLogger(AutoPageController.class);
    private static List<Object> naturalNumbersSequence = new LinkedList<>();

    static {

        for (int i = 2; i < 543; i++) {
            boolean bool = true;
            int x = (int) Math.sqrt(i);
            for (int j = 2; j <= x; j++) {
                if ((i % j) == 0) {
                    bool = false;
                    break;
                }
            }
            if (bool) naturalNumbersSequence.add(i);
        }
    }

    @GetMapping("/auto")
    public String auto(@RequestParam(required = false) String length, Model model) {
        log.info("ENTERED ARRAY LENGTH: " + length);
        log.info("THE GENERATED ARRAY OF NATURAL NUMBERS: " + naturalNumbersSequence);
        model.addAttribute("length", length);
        model.addAttribute("naturalNumbersSequence", naturalNumbersSequence);
        return "auto_page";
    }
}