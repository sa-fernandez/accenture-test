package com.franchise.project.requests;

public class StockRequest {

    private Long id;

    private int stock;

    public StockRequest() {
    }

    public StockRequest(Long id, int stock) {
        this.id = id;
        this.stock = stock;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
}
