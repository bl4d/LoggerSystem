package com.belatrix.loggersystem.filehelper;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import com.belatrix.loggersystem.model.Message;
import com.belatrix.loggersystem.util.ConfigUtil;

@Component
public class FileHelperComponent {
	
	@Autowired
	private ConfigUtil configUtil;
	
	public String fileWrite(Message message) throws Exception{
		
		  try {
	            String content = message.toString();
	    		File file = new File(configUtil.getProperty("log.file.name"));

	            if (!file.exists()) {
	                file.createNewFile();
	            }

	            FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
	            BufferedWriter bw = new BufferedWriter(fw);
	            bw.write(content);
	            
	            bw.close();

	            return file.getAbsolutePath();

	        } catch (Exception e) {
	            throw e;
	        }

	    }
	
	
	
	public String fileRead() throws Exception{
		
		 File file = new ClassPathResource(configUtil.getProperty("log.file.name")).getFile();

	        FileInputStream fis = null;
	        StringBuilder sb = new StringBuilder();

	        try {
	            fis = new FileInputStream(file);
	            System.out.println(file.getAbsolutePath());
	            System.out.println(file.getPath());
	            System.out.println("Total file size to read (in bytes) : "  + fis.available());

	            int content;
	            while ((content = fis.read()) != -1) {
	            	sb.append((char) content);
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	            throw e;
	        } finally {
	            try {
	                if (fis != null)
	                    fis.close();
	            } catch (IOException ex) {
	                ex.printStackTrace();
	               throw ex;
	            }

	        }

	        return sb.toString();
	
	}
			
		
	}


