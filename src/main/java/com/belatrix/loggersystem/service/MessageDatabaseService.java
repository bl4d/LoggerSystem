package com.belatrix.loggersystem.service;

import java.util.Map;

import com.belatrix.loggersystem.model.Message;


public interface MessageDatabaseService {
	
	public void addMessage(Message message);
	
	public Map<Integer,Message> getAllMessages();

}
