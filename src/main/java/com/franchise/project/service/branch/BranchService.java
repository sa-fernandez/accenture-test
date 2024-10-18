package com.franchise.project.service.branch;

import com.franchise.project.models.Product;

public interface BranchService {

    public boolean addProductToBranch(Long id, Product product);
    public boolean updateName(Long id, String newName);
    
}
