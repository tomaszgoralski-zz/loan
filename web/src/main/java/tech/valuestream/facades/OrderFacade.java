package tech.valuestream.facades;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tech.valuestream.converters.OrderConverter;
import tech.valuestream.dtos.OrderDTO;
import tech.valuestream.models.Order;
import tech.valuestream.services.OrderService;
import tech.valuestream.validators.OrderValidator;

import javax.servlet.http.HttpServletRequest;

@Component
public class OrderFacade {

    @Autowired
    public OrderConverter orderConverter;
    @Autowired
    public OrderValidator orderValidator;
    @Autowired
    public OrderService orderService;

//    System.out.println(order.getAmount());
//    System.out.println(order.getIp());
//    System.out.println(order.getWhenDate());
//    System.out.println(request.getRemoteAddr());

    public OrderDTO handle(OrderDTO orderDTO, HttpServletRequest request) {

        System.out.println("handling order");
        orderDTO.setIp(request.getRemoteAddr());
        if(! orderValidator.isValid(orderDTO)){
            orderDTO.setMessage("Required params missing!");
            return orderDTO;
        }
        Order order = orderConverter.convertToModel(orderDTO);
        orderService.checkRisk(order);
        return orderConverter.convertToDTO(orderService.create(order));
    }

}
