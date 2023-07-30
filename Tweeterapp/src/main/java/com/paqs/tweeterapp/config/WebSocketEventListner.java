package com.paqs.tweeterapp.config;

import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
//import org.apache.juli.logging.Log;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.paqs.tweeterapp.Chat.ChatMessage;
import com.paqs.tweeterapp.Chat.MessageType;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Slf4j
public class WebSocketEventListner {

	private static final Logger log = LoggerFactory.getLogger(WebSocketEventListner.class);

	private final SimpMessageSendingOperations messageTemplate = null; 
	
	@EventListener
	public void handleWebSocketDisconnectListner(
			SessionDisconnectEvent event) {
		StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
		String username= (String)headerAccessor.getSessionAttributes().get("username"); 
		if (username!=null) {
			log.info("User disconnected: {}", username);
			var chatMessage = ChatMessage.builder().type(MessageType.LEAVER).sender(username).build();
			messageTemplate.convertAndSend("/topic/public",chatMessage);
		}
	}
	
}
