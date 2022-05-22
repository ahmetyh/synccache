package com.ayh.synccache.service;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CachePublisher {

    public static Integer counter =0;

    @Autowired
    private FanoutExchange exchange;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void invalidate() {
        String command = "invalidate";
        rabbitTemplate.convertAndSend(exchange.getName(), "", command);
        System.out.println("Sent: " + command);
    }

}
