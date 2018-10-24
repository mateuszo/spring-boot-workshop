package com.codecool.springbootdemo.service;


import org.springframework.stereotype.Service;

@Service
public class GreetingServiceImpl implements GreetingService {
    @Override
    public String greet(String name) {
        return "Hello dear " + name + "!";
    }
}
