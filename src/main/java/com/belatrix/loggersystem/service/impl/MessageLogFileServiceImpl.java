package com.belatrix.loggersystem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.belatrix.loggersystem.filehelper.FileHelperComponent;
import com.belatrix.loggersystem.model.Message;
import com.belatrix.loggersystem.service.MessageLogFileService;

@Service
@Qualifier("ServiceLogFile")
public class MessageLogFileServiceImpl implements MessageLogFileService{
	
	
	@Autowired
	private FileHelperComponent fileHelperComponent;
	
	
	public String logToFile(Message message) throws Exception{
	
		try {
			return fileHelperComponent.fileWrite(message);
		} catch (Exception e) {
			
			throw e;
			
		}
		
	}
	
	public String getAllMessages(){
		
		String messages="";
		try {
			messages = fileHelperComponent.fileRead();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return  messages;
	}
	
	

}
