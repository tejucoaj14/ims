package com.example.ims.service;

import com.example.ims.model.Subscriber;

public interface SubscriberService {

    Subscriber getSubscriber(String phoneNumber);

    Subscriber saveSubscriber(String phoneNumber, Subscriber subscriber);

    void deleteSubscriber(String phoneNumber);
}