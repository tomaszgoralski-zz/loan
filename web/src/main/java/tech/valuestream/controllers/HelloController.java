package tech.valuestream.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController("/hello")
public class HelloController {

    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        return "HelloController - Greetings from Spring Boot!";
    }

}