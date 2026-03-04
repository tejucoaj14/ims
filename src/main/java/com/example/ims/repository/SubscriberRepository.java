package com.example.ims.repository;

import com.example.ims.model.Subscriber;
import org.springframework.stereotype.Repository;

import java.util.concurrent.ConcurrentHashMap;

@Repository
public class SubscriberRepository {

    private final ConcurrentHashMap<String, Subscriber> database = new ConcurrentHashMap<>();

    public Subscriber findByPhoneNumber(String phoneNumber) {
        return database.get(phoneNumber);
    }

    public Subscriber save(String phoneNumber, Subscriber subscriber) {
        database.put(phoneNumber, subscriber);
        return subscriber;
    }

    public void delete(String phoneNumber) {
        database.remove(phoneNumber);
    }

    public boolean exists(String phoneNumber) {
        return database.containsKey(phoneNumber);
    }
}