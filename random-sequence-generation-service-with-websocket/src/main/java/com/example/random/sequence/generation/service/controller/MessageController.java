package com.example.random.sequence.generation.service.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

@Controller
public class MessageController {
    private Logger log = LoggerFactory.getLogger(MessageController.class);

    @MessageMapping("length")
    public void receiveMessage(String content){
        log.info("browser send message content [{}]",content);
    }
}
