package com.example.greeting_app.controller;

import com.example.greeting_app.entity.GreetingEntity;
import com.example.greeting_app.service.GreetingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    // GET request to greet with firstname and lastname
    @GetMapping("/data")
    public String greetWithFullName(@RequestParam(required = false) String firstName, @RequestParam(required = false) String lastName){
        return greetingService.customGreetingMessage(firstName,lastName);
    }

    // POST request to save the message
    @PostMapping("/save")
    public GreetingEntity saveMessage(@RequestBody String message){
        return greetingService.saveMessage(message);
    }

    // GET request to get the message from ID
    @GetMapping("/get/{id}")
    public Optional<GreetingEntity> getMessageById(@PathVariable Long id){
        return greetingService.findMessageById(id);
    }

    // Get All Greeting Messages
    @GetMapping("/all")
    public List<GreetingEntity> getAllGreetings() {
        return greetingService.getAllGreetings();
    }

    // Update Greeting Message by id
    @PutMapping("/update/{id}")
    public GreetingEntity updateGreeting(@PathVariable Long id, @RequestBody GreetingEntity greeting) {
        return greetingService.updateGreeting(id, greeting.getMessage());
    }

    // Delete Greeting Message
    @DeleteMapping("/delete/{id}")
    public String deleteGreeting(@PathVariable Long id) {
        boolean deleted = greetingService.deleteGreeting(id);
        return deleted ? "Greeting deleted successfully" : "Greeting not found!";
    }
}