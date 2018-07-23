package com.kafkawebsocket.rayonit.kafkawebsocket.Configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    @Override
    public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {

        //ku do te behet connect websocket ne fillim
        stompEndpointRegistry.addEndpoint("/websocket-connect")
                .setAllowedOrigins("http://localhost:4200")
                .withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        //ku duam qe te bejme push mesazhet
        registry.enableSimpleBroker("/events");
        //prefiksi do te jete /app pastaj te tjerat
        registry.setApplicationDestinationPrefixes("/app");
    }
}
