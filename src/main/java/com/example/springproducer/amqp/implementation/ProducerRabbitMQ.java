package com.example.springproducer.amqp.implementation;

import com.example.springproducer.amqp.AmqpProducer;
import com.example.springproducer.dto.MessageQueue;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProducerRabbitMQ implements AmqpProducer<MessageQueue> {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    private String exchange;

    private String queue;

    @Override
    public void producer(MessageQueue message) {
        try {
            rabbitTemplate.convertAndSend(exchange, queue, message);
        }catch (Exception ex){
            throw  new AmqpRejectAndDontRequeueException(ex);
        }

    }
}
