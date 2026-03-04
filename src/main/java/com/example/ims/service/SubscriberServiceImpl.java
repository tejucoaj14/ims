package com.example.ims.service;

import com.example.ims.exception.SubscriberNotFoundException;
import com.example.ims.model.Subscriber;
import com.example.ims.repository.SubscriberRepository;
import org.springframework.stereotype.Service;

@Service
public class SubscriberServiceImpl implements SubscriberService {

    private final SubscriberRepository repository;

    public SubscriberServiceImpl(SubscriberRepository repository) {
        this.repository = repository;
    }

    @Override
    public Subscriber getSubscriber(String phoneNumber) {
        Subscriber subscriber = repository.findByPhoneNumber(phoneNumber);
        if (subscriber == null) {
            throw new SubscriberNotFoundException(phoneNumber);
        }
        return subscriber;
    }

    @Override
    public Subscriber saveSubscriber(String phoneNumber, Subscriber subscriber) {
        subscriber.setPhoneNumber(phoneNumber);
        return repository.save(phoneNumber, subscriber);
    }

    @Override
    public void deleteSubscriber(String phoneNumber) {
        if (!repository.exists(phoneNumber)) {
            throw new SubscriberNotFoundException(phoneNumber);
        }
        repository.delete(phoneNumber);
    }
}