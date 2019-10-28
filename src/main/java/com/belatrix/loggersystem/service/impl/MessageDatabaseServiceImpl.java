package com.belatrix.loggersystem.service.impl;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.belatrix.loggersystem.controller.MessageController;
import com.belatrix.loggersystem.model.Message;
import com.belatrix.loggersystem.repository.impl.MessageRepositoryImpl;
import com.belatrix.loggersystem.service.MessageDatabaseService;

@Service
@Qualifier("ServiceDatabase") 
public class MessageDatabaseServiceImpl implements MessageDatabaseService{
	
	private static final Logger logger = LoggerFactory.getLogger(MessageController.class);
	
	@Autowired
	@Qualifier("Database1")
	private MessageRepositoryImpl messageRepository;
	

	
	public void addMessage(Message message){
		if(logger.isDebugEnabled()){
			logger.debug(message.toString());
		}
	
		messageRepository.addMessage(message);
		
	}
	
	public Map<Integer,Message> getAllMessages(){
		
		return  messageRepository.getAllMessages();
	
	}
	
	
	
	
	

}
