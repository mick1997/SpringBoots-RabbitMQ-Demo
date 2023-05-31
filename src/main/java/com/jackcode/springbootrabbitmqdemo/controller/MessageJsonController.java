package com.jackcode.springbootrabbitmqdemo.controller;

import com.jackcode.springbootrabbitmqdemo.dto.User;
import com.jackcode.springbootrabbitmqdemo.publisher.RabbitMQJSONProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/jsonMessage")
public class MessageJsonController {

    private RabbitMQJSONProducer rabbitMQJSONProducer;

    public MessageJsonController(RabbitMQJSONProducer rabbitMQJSONProducer) {
        this.rabbitMQJSONProducer = rabbitMQJSONProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> sendJsonMessage(@RequestBody User user) {
        rabbitMQJSONProducer.sendJsonMessage(user);
        return ResponseEntity.ok("Json message sent to RabbitMQ ....");
    }
}
