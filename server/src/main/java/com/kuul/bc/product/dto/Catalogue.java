package com.kuul.bc.product.dto;

import java.util.ArrayList;
import java.util.List;

public class Catalogue {
    private String salesman;
    private List<Product> products = new ArrayList<>();

    public Catalogue() {

    }

    public Catalogue(String salesman, List<Product> products) {
        this.salesman = salesman;
        this.products = products;
    }

    public String getSalesman() {
        return salesman;
    }

    public void setSalesman(String salesman) {
        this.salesman = salesman;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
