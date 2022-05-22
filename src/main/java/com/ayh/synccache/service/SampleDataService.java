package com.ayh.synccache.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Service
public class SampleDataService {

    @Cacheable(cacheNames="data", sync=true)
    public List<String> getData() {
        System.out.println("Database called..");
        return Stream.of("this", "is", "a", "real", "service", "call").collect(Collectors.toList());
    }

}
