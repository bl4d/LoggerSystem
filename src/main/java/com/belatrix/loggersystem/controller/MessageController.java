package com.belatrix.loggersystem.controller;

import com.belatrix.loggersystem.model.Message;
import com.belatrix.loggersystem.service.impl.MessageLogFileServiceImpl;
import com.belatrix.loggersystem.service.impl.MessageDatabaseServiceImpl;
import com.belatrix.loggersystem.service.impl.MessageLogConsoleServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping (value="/api/logger")
public class MessageController {
	
	private static final Logger logger = LoggerFactory.getLogger(MessageController.class);
	
    @Autowired
    @Qualifier("ServiceDatabase")
    MessageDatabaseServiceImpl messageDatabaseService;
    
    @Autowired
    @Qualifier("ServiceLogFile")
    MessageLogFileServiceImpl messageLogFileService;
    
    @Autowired
    @Qualifier("ServiceLogConsole")
    MessageLogConsoleServiceImpl messageLogConsoleService;
    

    @GetMapping("/getAllDatabaseLogs")
    @ResponseBody
    public ResponseEntity<Map<Integer,Message>> getAllDatabaseLogs(){
        Map<Integer,Message> messages =  messageDatabaseService.getAllMessages();
        return new ResponseEntity<Map<Integer,Message>>(messages, HttpStatus.OK);
    }


    @PostMapping(value = "/logToDataBase",consumes = {"application/json"},produces = {"application/json"})
    @ResponseBody
    public ResponseEntity<Message> logToDataBase(@RequestBody Message message){
    	messageDatabaseService.addMessage(message);
        return new ResponseEntity<Message>(message,HttpStatus.CREATED);
    }
    
    
    @PostMapping(value = "/logToConsole",consumes = {"application/json"},produces = {"application/json"})
    @ResponseBody
    public ResponseEntity<Message> logToConsole(@RequestBody Message message){
    	try {
    		
	   	messageLogConsoleService.logToConsole(message);
			
		} catch (Exception e) {
			logger.error("Error method logToFile:"+e.getLocalizedMessage() + e.getMessage());
		}
        return new ResponseEntity<Message>(message,HttpStatus.CREATED);
    }

    
    
    @PostMapping(value = "/logToFile",consumes = {"application/json"},produces = {"application/json"})
    @ResponseBody
    public ResponseEntity<String> logToFile(@RequestBody Message message){
    	String file = "";
    	try {
    		
	    file = 	messageLogFileService.logToFile(message);
			
		} catch (Exception e) {
			logger.error("Error method logToFile:"+e.getLocalizedMessage() + e.getMessage());
		}
        return new ResponseEntity<String>(file,HttpStatus.CREATED);
    }
    
    
    
    
    
	/*/TODO develop in next version :)
	 * @GetMapping("/getAllLogsFromFile")
	 * 
	 * @ResponseBody public ResponseEntity<String> getAllLogsFromFile(){ String
	 * messages = messageLogFileService.getAllMessages(); return new
	 * ResponseEntity<String>(messages, HttpStatus.OK); }
	 */
    
    
    
    
    
    
    
    
    
    

}
