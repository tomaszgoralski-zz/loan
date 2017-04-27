package tech.valuestream.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tech.valuestream.dtos.OrderDTO;
import tech.valuestream.facades.OrderFacade;

@RestController
public class OrderController {

    @Autowired
    private OrderFacade orderFacade;

    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public OrderDTO index(@RequestBody OrderDTO order) {
        System.out.println(order.getAmount());
        System.out.println(order.getEmail());
        System.out.println(order.getWhenDate());

        orderFacade.handle(order);


        return order;
    }

}
