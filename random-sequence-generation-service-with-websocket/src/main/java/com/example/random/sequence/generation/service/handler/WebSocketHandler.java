package com.example.random.sequence.generation.service.handler;

import com.example.random.sequence.generation.service.controller.AutoPageController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

import java.io.IOException;
import java.util.stream.Collectors;

@Slf4j
public class WebSocketHandler extends AbstractWebSocketHandler {

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage length) throws IOException {
        log.info("LENGTH OF THE ARRAY IS INTRODUCED : " + length);
        session.sendMessage(length);
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        session.sendMessage(new TextMessage("You are now connected to the server. This is the first message."));
    }

    public void outputArray(WebSocketSession session, int length, AutoPageController autoPageController) throws IOException {
        autoPageController.auto(length);
        String result = autoPageController.randomArrayCertainLength.stream()
                .map(String::valueOf)
                .collect(Collectors.joining("-", "{", "}"));
        session.sendMessage(new TextMessage(result));
    }


//    @Override
//    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
//        session.sendMessage (new TextMessage ("!!!!!!!!!!!" .getBytes ()));
//
//    }

}