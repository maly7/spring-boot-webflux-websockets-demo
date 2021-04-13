package com.example.websocketdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.HandlerMapping;
import org.springframework.web.reactive.handler.SimpleUrlHandlerMapping;
import org.springframework.web.reactive.socket.WebSocketHandler;

import java.util.HashMap;

@Configuration
public class WebConfig {

    @Bean
    public HandlerMapping handlerMapping(EchoHandler echoHandler, GreetingHandler greetingHandler) {
        var map = new HashMap<String, WebSocketHandler>();
        map.put("/echo", echoHandler);
        map.put("/greetings", greetingHandler);
        int order = -1;

        return new SimpleUrlHandlerMapping(map, order);
    }
}
