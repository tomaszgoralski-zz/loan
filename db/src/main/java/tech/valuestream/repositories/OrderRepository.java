package tech.valuestream.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import tech.valuestream.models.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {

    Integer countByIp(@Param("ip") String ip);
}
