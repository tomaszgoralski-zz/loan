package tech.valuestream.services;

import org.springframework.stereotype.Component;
import tech.valuestream.models.Order;

@Component
public class OrderServiceImpl implements OrderService {

    @Override
    public void checkRisk(Order o) {
        if(isInAcceptableHours(o) && isNotMaxAmount(o) && hasSafeIp(o)){
            o.setRisk(Order.LOW_RISK);
        } else{
            o.setRisk(Order.HIGH_RISK);
        }
    }

    @Override
    public void create(Order o) {

    }

    @Override
    public boolean isInAcceptableHours(Order o) {
        return o.getWhenDate().getHour() > 0 && o.getWhenDate().getHour() < 6;
    }

    @Override
    public boolean hasSafeIp(Order o) {
        return false;
    }

    @Override
    public boolean isNotMaxAmount(Order o) {
        return o.getAmount() < Order.MAX_AMOUNT;
    }

}
