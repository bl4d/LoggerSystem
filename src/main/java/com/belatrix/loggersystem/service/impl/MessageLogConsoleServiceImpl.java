package com.belatrix.loggersystem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.belatrix.loggersystem.consolehelper.ConsoleHelperComponent;
import com.belatrix.loggersystem.model.Message;
import com.belatrix.loggersystem.service.MessageLogConsoleService;

@Service
@Qualifier("ServiceLogConsole")
public class MessageLogConsoleServiceImpl implements MessageLogConsoleService{

	@Autowired
	private ConsoleHelperComponent consoleLogHelper;
	
	@Override
	public void logToConsole(Message message) {
	
		consoleLogHelper.logToConsole(message);
		
	}
	
	
	

}
