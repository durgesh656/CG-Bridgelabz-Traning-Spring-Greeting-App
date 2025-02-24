package com.example.greeting_app.service;

import com.example.greeting_app.entity.GreetingEntity;
import com.example.greeting_app.repositories.GreetingRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GreetingService {
    private GreetingRepository greetingRepository;

    public GreetingService(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    public String getGreetingMessage(){
        return "Hello World";
    }

    public String customGreetingMessage(String firstName, String lastName){
        if(firstName != null && lastName != null){
            return "Hello " + firstName + " " + lastName + "!!";
        } else if (firstName != null) {
            return "Hello" + firstName + "!!";
        } else if (lastName != null) {
            return "Hello" + lastName + "!!";
        }else {
            return "Hello World";
        }
    }

    // Method to save the message
    public GreetingEntity saveMessage(String message){
        GreetingEntity greetingEntity = new GreetingEntity(message);
        return greetingRepository.save(greetingEntity);
    }




}