package com.anoystick;

import com.anoystick.entity.OrderEntity;
import com.anoystick.entity.ProductEntity;
import com.anoystick.repository.OrderRepository;
import com.anoystick.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
public class ProductOrderTest {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Test
    @Transactional
    @Rollback(false)
    public void manyToManyTest() {
        ProductEntity p1 = new ProductEntity();
        ProductEntity p2 = new ProductEntity();

        OrderEntity o1 = new OrderEntity();
        OrderEntity o2 = new OrderEntity();
        OrderEntity o3 = new OrderEntity();

        p1.setProductName("Tip 1");
        p1.setProductPrice(new BigDecimal("22.2"));
        p2.setProductName("Tip 2");
        p2.setProductPrice(new BigDecimal("11.1"));

        o1.setUserId(1);
        o2.setUserId(5);

        p1.setOrderList(List.of(o1,o2));
        p2.setOrderList(List.of(o1,o2,o3));

        productRepository.save(p1);
        productRepository.save(p2);

        orderRepository.save(o1);

    }
}
