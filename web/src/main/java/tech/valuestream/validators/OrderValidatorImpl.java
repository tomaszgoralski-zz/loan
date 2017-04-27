package tech.valuestream.validators;

import org.springframework.stereotype.Component;
import tech.valuestream.dtos.OrderDTO;
@Component
public class OrderValidatorImpl implements OrderValidator {
    @Override
    public boolean isValid(OrderDTO orderDTO) {

        boolean isValid = true;
        if(orderDTO.getAmount() == null || orderDTO.getWhenDate() == null || orderDTO.getIp() == null){
            isValid = false;
        }

        return isValid;
    }

}
