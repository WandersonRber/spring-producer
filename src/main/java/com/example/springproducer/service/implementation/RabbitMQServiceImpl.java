package com.example.springproducer.service.implementation;

import com.example.springproducer.amqp.AmqpProducer;
import com.example.springproducer.dto.MessageQueue;
import com.example.springproducer.service.AmqpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQServiceImpl implements AmqpService {

    @Autowired
    private AmqpProducer<MessageQueue> amqp;


    @Override
    public void sendToConsumer(MessageQueue message) {
        amqp.producer(message);
    }
}
