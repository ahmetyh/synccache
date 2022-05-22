package com.ayh.synccache.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

@Service
public class CacheListener {

    @Autowired
    CacheManager cacheManager;

    @RabbitListener(queues = "#{cacheQueue.name}")
    public void receive(String command)  {

        System.out.println(command + " command has been received");

        if (!"invalidate".equals(command)) {
            System.out.println("Invalid command!");
            return;
        }

        String cacheName="data";

        cacheManager.getCache(cacheName).clear();

        System.out.println(cacheName + " cache is invalidated");

    }


}
