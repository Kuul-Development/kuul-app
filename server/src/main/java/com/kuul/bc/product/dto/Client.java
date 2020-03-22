package com.kuul.bc.product.dto;

/**
 * Class to represent the client
 */
public class Client {
    private long id;

    public Client() {

    }

    public Client(long id){
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
