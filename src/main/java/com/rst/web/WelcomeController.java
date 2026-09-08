package com.rst.helloworld.web;

import java.util.Map;

import com.rst.helloworld.service.HelloWorldService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {

    private static final Logger logger =
            LoggerFactory.getLogger(WelcomeController.class);

    private final HelloWorldService helloWorldService;

    public WelcomeController(HelloWorldService helloWorldService) {
        this.helloWorldService = helloWorldService;
    }

    @GetMapping("/")
    public String index(Map<String, Object> model) {

        logger.debug("index() is executed!");

        model.put("title", helloWorldService.getTitle(""));
        model.put("msg", helloWorldService.getDesc());

        return "index";
    }

    @GetMapping("/hello/{name:.+}")
    public ModelAndView hello(@PathVariable String name) {

        logger.debug("hello() is executed - $name {}", name);

        ModelAndView model = new ModelAndView("index");

        model.addObject("title", helloWorldService.getTitle(name));
        model.addObject("msg", helloWorldService.getDesc());

        return model;
    }
}
