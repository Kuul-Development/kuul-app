package com.kuul.bc.product.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Order {
    private long orderId;
    private String supplierId;
    private List<Product> listOfOrderedProducts = new ArrayList<>();
    private boolean done = false;

    public Order() {

    }

    public Order(String supplier, Product product) {
        Random rand = new Random();
        this.orderId = 1 + rand.nextInt(100);
        this.supplierId = supplier;
        this.listOfOrderedProducts.add(product);
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public List<Product> getListOfOrderedProducts() {
        return listOfOrderedProducts;
    }

    public void setListOfOrderedProducts(List<Product> listOfOrderedProducts) {
        this.listOfOrderedProducts = listOfOrderedProducts;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
