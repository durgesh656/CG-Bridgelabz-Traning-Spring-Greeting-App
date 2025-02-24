package com.example.greeting_app.repositories;

import com.example.greeting_app.dto.Greeting;
import com.example.greeting_app.entity.GreetingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GreetingRepository extends JpaRepository<GreetingEntity, Long> {
}
