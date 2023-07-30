package com.paqs.tweeterapp.Chat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ChatMessage {

	private String content;
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public MessageType getType() {
		return type;
	}
	public void setType(MessageType type) {
		this.type = type;
	}
	private String sender;
	private MessageType type;
	
	


//    private String sender;
//    private String content;
//
//    private ChatMessage() {} // Private constructor

    public static Builder builder() {
        return new Builder();
    }

    // Getters for sender and content (you can also add setters if needed)

    // Nested builder class
    public static class Builder {
        private String sender;
        private String content;

        public Builder sender(String sender) {
            this.sender = sender;
            return this;
        }

        public Builder content(String content) {
            this.content = content;
            return this;
        }

        public ChatMessage build() {
            ChatMessage message = new ChatMessage();
            message.sender = this.sender;
            message.content = this.content;
            return message;
        }

		public Builder type(MessageType leaver) {
			// TODO Auto-generated method stub
			return null;
		}
    }
}

