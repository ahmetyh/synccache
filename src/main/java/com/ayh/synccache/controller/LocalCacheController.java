package com.ayh.synccache.controller;

import com.ayh.synccache.service.CachePublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocalCacheController {

    @Autowired
    CachePublisher cachePublisher;

    @GetMapping("/invalidate")
    public String invalidate() {

        cachePublisher.invalidate();

        return "Cache invalidate command has been sent to all instances!";
    }

}
