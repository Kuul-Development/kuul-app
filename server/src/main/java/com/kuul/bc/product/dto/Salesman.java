package com.kuul.bc.product.dto;

/**
 * Class to represent a salesman, business or shop
 */
public class Salesman {

    private long id;
    private String name;

    public Salesman() {
    }

    public Salesman(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
