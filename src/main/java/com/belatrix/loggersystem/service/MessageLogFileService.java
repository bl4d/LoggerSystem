package com.belatrix.loggersystem.service;

import com.belatrix.loggersystem.model.Message;

public interface MessageLogFileService {
	
	public String logToFile(Message message) throws Exception;
	
	public String getAllMessages() throws Exception;

}
