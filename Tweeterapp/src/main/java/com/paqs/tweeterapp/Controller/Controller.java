package com.paqs.tweeterapp.Controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;

import com.paqs.tweeterapp.Chat.ChatMessage;

//import org.springframework.stereotype.Controller

@org.springframework.stereotype.Controller
public class Controller {

	@MessageMapping("/chat.addUser")
	@SendTo("/topic/public")
	public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
		return chatMessage;		
	}
	
	@MessageMapping("/chat,sendMessage")
	@SendTo("/topic/public")
	public ChatMessage addUser(@Payload ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor) {
		//Add username in WebSocket session
		headerAccessor.getSessionAttributes().put("username",chatMessage.getSender());
		return chatMessage;
	}
}
