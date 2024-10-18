package com.franchise.project.dto;

public class ProductBranchDTO {

    private String productName;

    private int stock;

    private String branchName;

    public ProductBranchDTO() {
    }

    public ProductBranchDTO(String productName, int stock, String branchName) {
        this.productName = productName;
        this.stock = stock;
        this.branchName = branchName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }
    
}
