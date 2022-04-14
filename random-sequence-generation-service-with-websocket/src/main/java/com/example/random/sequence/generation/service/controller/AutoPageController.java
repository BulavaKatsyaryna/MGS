package com.example.random.sequence.generation.service.controller;

import com.example.random.sequence.generation.service.model.IterationNaturalNumbers;
import com.example.random.sequence.generation.service.model.MessageResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
@Controller
public class AutoPageController extends IterationNaturalNumbers {

    Random random = new SecureRandom();
    protected final List<Object> randomArrayCertainLength = new ArrayList<>();
    protected Object randomArrayCertainLengthResult;

    @MessageMapping("/auto")
    @SendTo("/topic/auto")
    public MessageResponse auto(@RequestParam(required = false) int length) {

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

        return new MessageResponse("Random collection output: " + randomArrayCertainLengthResult);
    }
}
