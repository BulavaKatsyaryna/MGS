package com.example.random.sequence.generation.service.config;

import com.example.random.sequence.generation.service.model.MessageResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Slf4j
@EnableScheduling
@Configuration
public class SchedulerConfig {

    SimpMessagingTemplate template;

    @Scheduled(fixedDelay = 2000)
    public void sendAdhocMessages() {
        log.info("OUTPUT AUTOGENERATE");
        template.convertAndSend("/topic/auto", new MessageResponse("AutoGeneration: "));
    }
}
