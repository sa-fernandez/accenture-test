package com.franchise.project.requests;

public class ProductBranchRequest {

    private Long branchId;

    private String productName;

    private int productStock;

    public ProductBranchRequest() {
    }

    public ProductBranchRequest(Long branchId, String productName, int productStock) {
        this.branchId = branchId;
        this.productName = productName;
        this.productStock = productStock;
    }

    public Long getBranchId() {
        return branchId;
    }

    public void setBranchId(Long branchId) {
        this.branchId = branchId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductStock() {
        return productStock;
    }

    public void setProductStock(int productStock) {
        this.productStock = productStock;
    }
    
}
