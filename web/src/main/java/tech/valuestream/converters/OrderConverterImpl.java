package tech.valuestream.converters;

import org.springframework.stereotype.Component;
import tech.valuestream.dtos.OrderDTO;
import tech.valuestream.models.Order;

@Component
public class OrderConverterImpl implements OrderConverter {

    @Override
    public OrderDTO convertToDTO(Order order) {
        return null;
    }

    @Override
    public Order convertToModel(OrderDTO orderDTO) {
        return null;
    }
}
