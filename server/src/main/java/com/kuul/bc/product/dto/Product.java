package com.kuul.bc.product.dto;

public class Product {

    private String productId;
    private String description;
    private long amount;
    private String salesman;
    private double price;

    public Product() {

    }

    public Product(String productId, String description, long amount, String salesman, double price) {
        this.productId = productId;
        this.description = description;
        this.amount = amount;
        this.salesman = salesman;
        this.price = price;
    }

    public String getProductId() {
        return productId;
    }

    public String getDescription() {
        return description;
    }

    public long getAmount() {
        return amount;
    }

    public String getSalesman() {
        return salesman;
    }

    public double getPrice() {
        return price;
    }

    void setProductId(String productId) {
        this.productId = productId;
    }

    void setDescription(String description) {
        this.description = description;
    }

    void setAmount(long amount) {
        this.amount = amount;
    }

    void setSalesman(String salesman) { this.salesman = salesman; }

    void setPrice(double price) { this.price = price; }
}
