package com.kuul.bc.product.dto;

/**
 * Class to represent a product
 */
public class Product {

    private String product;
    private String description;
    private long amount;
    private double price;

    public Product() {
    }

    public Product(String product, String description, long amount, double price) {
        this.product = product;
        this.description = description;
        this.amount = amount;
        this.price = price;
    }

    public String getProduct() {
        return product;
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

    void setProduct(String product) {
        this.product = product;
    }

    void setDescription(String description) {
        this.description = description;
    }

    void setAmount(long amount) {
        this.amount = amount;
    }

    void setPrice(double price) { this.price = price; }
}
