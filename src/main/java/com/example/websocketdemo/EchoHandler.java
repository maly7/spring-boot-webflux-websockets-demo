package com.example.websocketdemo;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketSession;
import reactor.core.publisher.Mono;

@Component
public class EchoHandler implements WebSocketHandler {

    @Override
    public Mono<Void> handle(WebSocketSession session) {
        return session
                .send(session.receive()
                        .map(msg -> "Echo " + msg.getPayloadAsText())
                        .map(session::textMessage)
                );
    }
}
