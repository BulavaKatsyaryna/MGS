package com.example.random.sequence.generation.service.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.socket.BinaryMessage;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

import java.io.IOException;

@Slf4j
public class WebSocketHandler extends AbstractWebSocketHandler {

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage length) throws IOException {
        log.info("LENGTH OF THE ARRAY IS INTRODUCED : " + length);
        session.sendMessage(length);
    }

    @Override
    protected void handleBinaryMessage(WebSocketSession session, BinaryMessage message) throws IOException {
        log.info("NEW BINARY MESSAGE RECEIVED");
        session.sendMessage(message);
    }
}