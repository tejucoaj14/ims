package com.example.ims.controller;

import com.example.ims.model.Subscriber;
import com.example.ims.service.SubscriberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ims/subscriber")
public class SubscriberController {

    private final SubscriberService service;

    public SubscriberController(SubscriberService service) {
        this.service = service;
    }

    @GetMapping("/{phoneNumber}")
    public ResponseEntity<Subscriber> getSubscriber(@PathVariable String phoneNumber) {
        return ResponseEntity.ok(service.getSubscriber(phoneNumber));
    }

    @PutMapping("/{phoneNumber}")
    public ResponseEntity<Subscriber> saveSubscriber(
            @PathVariable String phoneNumber,
            @RequestBody Subscriber subscriber) {

        Subscriber saved = service.saveSubscriber(phoneNumber, subscriber);
        return ResponseEntity.ok(saved);
    }

    @DeleteMapping("/{phoneNumber}")
    public ResponseEntity<Void> deleteSubscriber(@PathVariable String phoneNumber) {
        service.deleteSubscriber(phoneNumber);
        return ResponseEntity.noContent().build();
    }
}