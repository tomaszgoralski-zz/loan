package tech.valuestream.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tech.valuestream.models.Order;
import tech.valuestream.repositories.OrderRepository;

@Component
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void checkRisk(Order o) {
        if(isInAcceptableHours(o) && isNotMaxAmount(o) && hasSafeIp(o)){
            o.setRisk(Order.LOW_RISK);
        } else{
            o.setRisk(Order.HIGH_RISK);
        }
    }

    @Override
    public Order create(Order o) {
        o.resolveStatus();
        return orderRepository.save(o);
    }

    @Override
    public boolean isInAcceptableHours(Order o) {
        return o.getWhenDate().getHour() > 6;
    }

    @Override
    public boolean hasSafeIp(Order o) {
        return orderRepository.countOrdersFromIp(o.getIp()) < 3;
    }

    @Override
    public boolean isNotMaxAmount(Order o) {
        return o.getAmount() < Order.MAX_AMOUNT;
    }

}
