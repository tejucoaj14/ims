package com.example.ims.exception;

public class SubscriberNotFoundException extends RuntimeException {

    public SubscriberNotFoundException(String phoneNumber) {
        super("Subscriber not found with phone number: " + phoneNumber);
    }
}