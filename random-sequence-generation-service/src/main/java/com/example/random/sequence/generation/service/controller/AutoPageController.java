package com.example.random.sequence.generation.service.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.SecureRandom;
import java.util.*;

@Controller
public class AutoPageController {
    private static final Logger log = LoggerFactory.getLogger(AutoPageController.class);
    private static final List<Object> naturalNumbersSequence = new LinkedList<>();

    Random random = new SecureRandom();
    private final List<Object> randomArrayCertainLength = new ArrayList<>(naturalNumbersSequence);

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
    public String auto(@RequestParam(required = false) int length, Model model) {

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(randomArrayCertainLength.size());
            var randomElement = randomArrayCertainLength.get(randomIndex);
            log.info("RANDOM ARRAY OF SELECTED LENGTH: " + randomElement);
            randomArrayCertainLength.add(randomElement);
        }

        log.info("ENTERED ARRAY LENGTH: " + length);
        log.info("ARRAY OUTPUT: " + randomArrayCertainLength);
        model.addAttribute("length", length);
        model.addAttribute("randomArrayCertainLength", randomArrayCertainLength);
        return "auto_page";
    }
}