package tech.valuestream.services;

import tech.valuestream.models.Order;

public interface OrderService {

    void checkRisk(Order o); // order.risk
    void  create(Order o); //
    boolean isInAcceptableHours(Order o);
    boolean hasSafeIp(Order o);
    boolean isNotMaxAmount(Order o);
}
