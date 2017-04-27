package tech.valuestream.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import tech.valuestream.models.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {

    @Query("SELECT COUNT(o) FROM Order o WHERE o.ip=:ip")
    Integer countOrdersFromIp(@Param("ip") String ip);

}
