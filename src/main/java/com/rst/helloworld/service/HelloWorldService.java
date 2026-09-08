package com.rst.helloworld.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class HelloWorldService {

    private static final Logger logger =
            LoggerFactory.getLogger(HelloWorldService.class);

    public String getDesc() {

        logger.debug("getDesc() is executed!");

        return "Maven + Spring MVC + Jenkins + Docker Example";
    }

    public String getTitle(String name) {

        logger.debug("getTitle() is executed! $name : {}", name);

        if (name == null || name.isEmpty()) {
            return "Hello Docker";
        } else {
            return "Hello " + name;
        }
    }
}
