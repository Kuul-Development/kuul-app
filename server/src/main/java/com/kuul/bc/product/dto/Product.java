package com.kuul.bc.product.dto;

public class Product {

    private String productId;
    private String description;
    private long amount;
    private double price;

    public Product() {
    }

    public Product(String productId, String description, long amount, double price) {
        this.productId = productId;
        this.description = description;
        this.amount = amount;
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

    void setPrice(double price) { this.price = price; }
}
