package com.kuul.bc.product.resource;

import static org.assertj.core.api.Assertions.assertThat;

import com.kuul.bc.product.dto.Order;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

class SupplierViewResourceTest {
    @Test
    void shouldFindOrderById() {
        // given
        Order order1 = new Order();
        order1.setOrderId(1);
        Order order2 = new Order();
        order2.setOrderId(2);
        List<Order> orders = Arrays.asList(order1, order2);

        // when
        Optional<Order> result = SupplierViewResource.findOrderById(orders, 2);

        // then
        assertThat(result).isPresent();
        assertThat(result).contains(order2);
    }
}
