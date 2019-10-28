package com.belatrix.loggersystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import com.belatrix.loggersystem.model.Message;

@SpringBootApplication
public class LoggerSystemApplication {
	
	
	  @Bean
	  JedisConnectionFactory jedisConnectionFactory(){
	    return new JedisConnectionFactory();
	  }

	  @Bean
	  RedisTemplate<String, Message> redisTemplate(){
	    RedisTemplate<String,Message> redisTemplate = new RedisTemplate<String, Message>();
	    redisTemplate.setConnectionFactory(jedisConnectionFactory());
	    return redisTemplate;
	  }
	
	

	public static void main(String[] args) {
		SpringApplication.run(LoggerSystemApplication.class, args);
	}

}
