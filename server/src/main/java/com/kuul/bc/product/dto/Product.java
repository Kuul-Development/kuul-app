package com.kuul.bc.product.dto;

public class Product {

    private String productId;
    private String description;
    private long amount;

    public Product() {

    }

    public Product(String productId, String description, long amount) {
        this.productId = productId;
        this.description = description;
        this.amount = amount;
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

    void setProductId(String productId) {
        this.productId = productId;
    }

    void setDescription(String description) {
        this.description = description;
    }

    void setAmount(long amount) {
        this.amount = amount;
    }
}
