package com.kuul.bc.product.business;

import com.kuul.bc.product.dto.Order;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

/**
 * Business layer for the supplier view
 */
public class SupplierViewBL {
    @Inject
    private ClientViewBL clientViewBL;

    /**
     * Set an order of products to be done
     */
    public void markOrderAsDone(long orderId) {
        Optional<Order> order = findOrderById(clientViewBL.getAllOrders(), orderId);
        order.ifPresent(o -> o.setDone(true));
    }

    private Optional<Order> findOrderById(List<Order> orders, long orderId) {
        return orders.stream().filter(o -> o.getOrderId() == orderId).findFirst();
    }
}
