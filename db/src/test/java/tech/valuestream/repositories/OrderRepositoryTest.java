package tech.valuestream.repositories;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tech.valuestream.TestRunner;
import tech.valuestream.models.Order;

import java.time.LocalDateTime;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {TestRunner.class})
public class OrderRepositoryTest {

    @Autowired
    private OrderRepository orderRepository;

    @Test
    public void shouldCountByIp() {
        // given
        String ip1 = "127.168.0.1";
        String ip2 = "127.168.0.2";

        // when
        Order order = new Order();
        order.setIp(ip1);
        orderRepository.save(new Order(100.0, LocalDateTime.now().withHour(10), ip1));
        orderRepository.save(new Order(200.0, LocalDateTime.now().withHour(11), ip1));
        orderRepository.save(new Order(300.0, LocalDateTime.now().withHour(12), ip1));

        order.setIp(ip2);
        orderRepository.save(new Order(400.0, LocalDateTime.now().withHour(13), ip2));
        orderRepository.save(new Order(500.0, LocalDateTime.now().withHour(14), ip2));

        // then
        Assert.assertTrue(3 == orderRepository.countByIp(ip1));
        Assert.assertTrue(2 == orderRepository.countByIp(ip2));
    }
}