package tech.valuestream.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import tech.valuestream.models.Order;
import tech.valuestream.repositories.OrderRepository;

@RestController("/hello")
public class HelloController {

    private static final Logger log = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private OrderRepository orderRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String index() {

        for (Order order : orderRepository.findAll()) {
            log.info(order.toString());
        }

        return "HelloController - Greetings from Spring Boot!";
    }

}