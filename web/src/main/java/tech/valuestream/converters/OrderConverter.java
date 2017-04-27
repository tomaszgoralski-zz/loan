package tech.valuestream.converters;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import tech.valuestream.dtos.OrderDTO;
import tech.valuestream.models.Order;

public interface OrderConverter extends Converter<Order,OrderDTO> {

}
