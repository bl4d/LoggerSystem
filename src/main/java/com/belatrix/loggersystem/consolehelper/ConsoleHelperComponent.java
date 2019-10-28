package com.belatrix.loggersystem.consolehelper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.belatrix.loggersystem.controller.MessageController;
import com.belatrix.loggersystem.model.Message;
import com.belatrix.loggersystem.model.MessageType;

@Component
public class ConsoleHelperComponent {
	
	private static final Logger logger = LoggerFactory.getLogger(MessageController.class);
	
	
	public void logToConsole(Message message) {
		
		if(message.getMessageType().equalsIgnoreCase(MessageType.MESSAGE.toString())) {
			
			logger.info(message.toString());
		}
		
		if(message.getMessageType().equalsIgnoreCase(MessageType.ERROR.toString())) {
			
			logger.error(message.toString());
		}
		
		if(message.getMessageType().equalsIgnoreCase(MessageType.WARN.toString())) {
			
			logger.warn(message.toString());
		}
		
		
	}
	
	
	
	
	
	

}
