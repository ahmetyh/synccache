package com.ayh.synccache.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

    @Value("${fanout.name}")
    private String fanoutName;

    @Bean
    public FanoutExchange exchange() {
        return new FanoutExchange(fanoutName);
    }

    @Bean
    public Queue cacheQueue() {
        return new AnonymousQueue();
    }

    @Bean
    public Binding cacheBinding(FanoutExchange fanout, Queue cacheQueue) {
        return BindingBuilder.bind(cacheQueue).to(fanout);
    }

}
