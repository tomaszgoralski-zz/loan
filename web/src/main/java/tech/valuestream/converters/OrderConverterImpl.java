package tech.valuestream.converters;

import org.springframework.stereotype.Component;
import tech.valuestream.dtos.OrderDTO;
import tech.valuestream.models.Order;

@Component
public class OrderConverterImpl implements OrderConverter {

    @Override
    public OrderDTO convertToDTO(Order order) {
        OrderDTO dto = new OrderDTO();
        dto.setMessage("Your submission was: " + order.getStatus());
        return dto;
    }

    @Override
    public Order convertToModel(OrderDTO orderDTO) {
        Order order = new Order();
        order.setAmount(orderDTO.getAmount());
        order.setIp(orderDTO.getIp());
        order.setWhenDate(orderDTO.getWhenDate());
        return order;
    }
}
