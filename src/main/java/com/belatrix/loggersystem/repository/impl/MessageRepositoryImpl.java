package com.belatrix.loggersystem.repository.impl;

import  com.belatrix.loggersystem.model.Message;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
@Qualifier("Database1")
public class MessageRepositoryImpl {

    public static final String KEY = "MESSAGE";
    private RedisTemplate<String,Message> redisTemplate;
    private HashOperations<String, Integer, Message> hashOperations;

    public MessageRepositoryImpl(RedisTemplate<String, Message> redisTemplate) {
        this.redisTemplate = redisTemplate;
        hashOperations = redisTemplate.opsForHash();
    }

    /*Getting all Messages*/
    public Map<Integer,Message> getAllMessages(){
        return hashOperations.entries(KEY);
    }
    /*Getting a specific message by message id*/
    public Message getMessage(int messageId){
        return (Message) hashOperations.get(KEY,messageId);
    }

    /*Adding an message*/
    public void addMessage(Message message){
        hashOperations.put(KEY,message.getId(),message);
    }
    /*delete an message */
    public void deleteMessage(int id){
        hashOperations.delete(KEY,id);
    }

    /*update an message*/
    public void updateMessage(Message message){
        addMessage(message);
    }
    
}
