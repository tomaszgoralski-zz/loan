package tech.valuestream.facades;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tech.valuestream.converters.OrderConverter;
import tech.valuestream.dtos.OrderDTO;
import tech.valuestream.models.Order;
import tech.valuestream.services.OrderService;

@Component
public class OrderFacade {

    @Autowired
    public OrderConverter orderConverter;
    @Autowired
    public OrderService orderService;

    public OrderDTO handle(OrderDTO orderDTO) {
        System.out.println("handling order");
        Order order = orderConverter.convertToModel(orderDTO);
        orderService.checkRisk(order);
        orderService.create(order);
        return orderConverter.convertToDTO(order);
    }

}
