package com.belatrix.loggersystem.repository;

import java.util.Map;

import com.belatrix.loggersystem.model.Message;

public interface MessageRepository {
	

    /*Getting all Messages*/
    public Map<Integer,Message> getAllMessages();
    
    
    /*Getting a specific message by message id*/
    public Message getMessage(int messageId);

    /*Adding an message*/
    public void addMessage(Message message);
    
    
    /*delete an message */
    public void deleteMessage(int id);

    /*update an message*/
    public void updateMessage(Message message);
	
	
}







