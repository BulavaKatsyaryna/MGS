package com.example.random.sequence.generation.service.controller;

import com.example.random.sequence.generation.service.model.IterationNaturalNumbers;
import com.example.random.sequence.generation.service.model.MessageResponse;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@NoArgsConstructor
public class GeneratePageController extends IterationNaturalNumbers {

    @MessageMapping("/generate")
    @SendTo("/topic/generate")
    public MessageResponse generate(@RequestParam(required = false) Integer length) {

        naturalNumberSelection();
        choiceSixNaturalNumbers();

        log.info("ARRAY OUTPUT ON THE GENERATION PAGE: " + getArrayWithSixNumbers());
        log.info("ARRAY OUTPUT ON THE GENERATION PAGE: " + getArrayWithSixNumbers2());
        log.info("ARRAY OUTPUT ON THE GENERATION PAGE: " + getArrayWithSixNumbers3());
        log.info("ARRAY OUTPUT ON THE GENERATION PAGE: " + getArrayWithSixNumbers4());
        log.info("ARRAY OUTPUT ON THE GENERATION PAGE: " + getArrayWithSixNumbers5());

        return new MessageResponse("Five random sequences generated: "
                + arrayWithSixNumbers + " "
                + arrayWithSixNumbers2 + " "
                + arrayWithSixNumbers3 + " "
                + arrayWithSixNumbers4 + " "
                + arrayWithSixNumbers5 + " ");
    }
}