package com.example.random.sequence.generation.service.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

import java.io.IOException;

public class WebSocketHandler extends AbstractWebSocketHandler {
    private static final Logger log = LoggerFactory.getLogger(WebSocketHandler.class);

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage messages) throws IOException {
        log.info("POSTED MESSAGE: " + messages);
        session.sendMessage(messages);
    }
}