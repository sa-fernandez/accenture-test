package com.franchise.project.requests;

public class NewObjectRequest {

    private String name;

    private int stock;

    public NewObjectRequest() {
    }

    public NewObjectRequest(String name) {
        this.name = name;
    }
    
    public NewObjectRequest(String name, int stock) {
        this.name = name;
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
}
