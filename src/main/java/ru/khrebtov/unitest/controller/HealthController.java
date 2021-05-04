package ru.khrebtov.unitest.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {
    @RequestMapping(value = "/isAlive2", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
    public String isAlive(){
        return "Hello, i am is ALIVE!";
    }
}