package tech.valuestream.services;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tech.valuestream.models.Order;
import tech.valuestream.repositories.OrderRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertFalse;
import static org.mockito.Mockito.when;

public class OrderServiceImplTest {

    @InjectMocks
    private OrderService orderService = new OrderServiceImpl();

    @Mock
    private OrderRepository orderRepository;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldHasLowRiskCheck() {
        // given
        String ip = "192.168.0.0";
        Order o = new Order();
        o.setAmount(1000.0);
        o.setWhenDate(LocalDateTime.now().withHour(10));
        o.setIp(ip);
        when(orderRepository.countByIp(ip)).thenReturn(0);
        // when
        orderService.checkRisk(o);
        // then
        assertTrue(Order.LOW_RISK.equals(o.getRisk()));
        assertTrue(o.isLowRisk());
    }

    @Test
    public void shouldHasHighRiskCheck() {
        // given
        String ip = "192.168.0.0";
        Order o = new Order();
        o.setAmount(1000.0);
        o.setWhenDate(LocalDateTime.now().withHour(10));
        o.setIp(ip);
        when(orderRepository.countByIp(ip)).thenReturn(3);
        // when
        orderService.checkRisk(o);
        // then
        assertTrue(Order.HIGH_RISK.equals(o.getRisk()));
        assertFalse(o.isLowRisk());
    }

    @Test
    public void shouldHasAcceptableHours() {
        // given
        List<Order> orders = new ArrayList<>();
        for(int i= 7;i<24;i++){
            Order o = new Order();
            LocalDateTime today = LocalDateTime.now().withHour(i);
            o.setWhenDate(today);
            orders.add(o);
        }
        // when
        for(Order o : orders) {
            // then
            assertTrue(new OrderServiceImpl().isInAcceptableHours(o));
        }
    }

    @Test
    public void shouldHasNotAcceptableHours() {
        // given
        List<Order> orders = new ArrayList<>();
        for(int i= 0;i<7;i++){
            Order o = new Order();
            LocalDateTime today = LocalDateTime.now().withHour(i);
            o.setWhenDate(today);
            orders.add(o);
        }
        // when
        for(Order o : orders) {
            // then
            assertFalse(new OrderServiceImpl().isInAcceptableHours(o));
        }
    }

    @Test
    public void shouldHasNotSafeIp() {
        // given
        String ip = "192.168.0.0";
        Order o = new Order();
        o.setIp(ip);
        when(orderRepository.countByIp(ip)).thenReturn(3);
        // when
        boolean hasSafeIp = orderService.hasSafeIp(o);
        // then
        assertFalse(hasSafeIp);
    }

    @Test
    public void shouldHasSafeIp() {
        // given
        String ip = "192.168.0.0";
        Order o = new Order();
        o.setIp(ip);
        when(orderRepository.countByIp(ip)).thenReturn(2);
        // when
        boolean hasSafeIp = orderService.hasSafeIp(o);
        // then
        assertTrue(hasSafeIp);
    }

    @Test
    public void shouldHasLessThanMaxAmount() {
        // given
        Order o = new Order();
        o.setAmount(Order.MAX_AMOUNT - 500);
        // when
        boolean isNotMaxAmount = new OrderServiceImpl().isNotMaxAmount(o);
        // then
        assertTrue(isNotMaxAmount);
    }

    @Test
    public void shouldHasMaxAmount() {
        // given
        Order o = new Order();
        o.setAmount(Order.MAX_AMOUNT);
       // when
        boolean isNotMaxAmount = new OrderServiceImpl().isNotMaxAmount(o);
        // then
        assertFalse(isNotMaxAmount);
    }

}
