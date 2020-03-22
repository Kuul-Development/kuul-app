package com.kuul.bc.product.dto;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * class to represent a registered order for client at salesman
 */
public class Order {
    private long orderId;
    private Client client;
    private Map<Salesman, List<Product>> listOfOrderedProducts = new HashMap<> ();
    private boolean done = false;

    public Order() {

    }

    public Order(long id, Client client, Salesman salesman, Product product) {
        this.orderId = id;
        this.client = client;
        this.listOfOrderedProducts.put(salesman, Collections.singletonList(product));
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Map<Salesman, List<Product>> getListOfOrderedProducts() {
        return listOfOrderedProducts;
    }

    public void setListOfOrderedProducts(Map<Salesman, List<Product>> listOfOrderedProducts) {
        this.listOfOrderedProducts = listOfOrderedProducts;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
