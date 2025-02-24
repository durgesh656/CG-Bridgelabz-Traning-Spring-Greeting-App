package com.example.greeting_app.controller;

import com.example.greeting_app.service.GreetingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("greet/hello")
public class GreetingServiceController {

    private final GreetingService greetingService;

    public GreetingServiceController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping
    public String sayHello() {
        return greetingService.getGreetingMessage();
    }
}