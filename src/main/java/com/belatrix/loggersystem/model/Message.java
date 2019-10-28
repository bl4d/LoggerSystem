package com.belatrix.loggersystem.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("MESSAGE")
public class Message implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private int id;
    private String messageText;
    private LocalDateTime timeStamp;
    private String messageType;

    public Message() {
    }
    

	public Message(int id, String messageText, LocalDateTime timeStamp, String messageType) {
		super();
		this.id = id;
		this.messageText = messageText;
		this.timeStamp = timeStamp;
		this.messageType = messageType;
	}



	@Override
	public String toString() {
		return "[id=" + id + ", messageText=" + messageText + ", timeStamp=" + timeStamp + ", messageType="
				+ messageType + "]\n";
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMessageText() {
		return messageText;
	}

	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}

	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getMessageType() {
		return messageType;
	}

	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}
    
    
    
    
    
    
    


}
