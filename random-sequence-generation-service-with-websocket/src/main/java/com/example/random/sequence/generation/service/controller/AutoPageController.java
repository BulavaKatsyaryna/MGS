package com.example.random.sequence.generation.service.controller;

import com.example.random.sequence.generation.service.model.IterationNaturalNumbers;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.minidev.json.JSONArray;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@EqualsAndHashCode(callSuper = true)
@Data
@Slf4j
@NoArgsConstructor
@AllArgsConstructor
@Controller
public class AutoPageController extends IterationNaturalNumbers {

    Random random = new SecureRandom();
    public final List<Object> randomArrayCertainLength = new ArrayList<>();
    public String randomArrayCertainLengthResult;
    JSONArray autoPageJSON = new JSONArray();

    @MessageMapping("/auto")
    @SendTo("/topic/auto")
    public void auto (int length, Model model) {

        naturalNumberSelection();

        randomArrayCertainLength.clear();

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(naturalNumbersSequence.size());
            var randomElement = naturalNumbersSequence.get(randomIndex);
            log.info("RANDOM ARRAY OF SELECTED LENGTH: " + randomElement);
            randomArrayCertainLength.add(randomElement);
        }

        randomArrayCertainLengthResult = randomArrayCertainLength.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" ", "[", "]"));

        autoPageJSON.add(randomArrayCertainLengthResult);
        model.addAttribute("autoPageJSON", autoPageJSON);
    }
}
