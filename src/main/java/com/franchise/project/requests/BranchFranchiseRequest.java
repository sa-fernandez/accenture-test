package com.franchise.project.requests;

public class BranchFranchiseRequest {

    private Long franchiseId;

    private String branchName;

    public BranchFranchiseRequest() {
    }

    public BranchFranchiseRequest(Long franchiseId, String branchName) {
        this.franchiseId = franchiseId;
        this.branchName = branchName;
    }

    public Long getFranchiseId() {
        return franchiseId;
    }

    public void setFranchiseId(Long franchiseId) {
        this.franchiseId = franchiseId;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }
    
}
