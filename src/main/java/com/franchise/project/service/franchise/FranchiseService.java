package com.franchise.project.service.franchise;

import java.util.List;

import com.franchise.project.dto.ProductBranchDTO;
import com.franchise.project.models.Branch;

public interface FranchiseService {
    
    public boolean addFranchise(String name);
    public boolean addBranchToFranchise(Long id, Branch branch);
    public List<ProductBranchDTO> listMaxStock(Long id);
    public boolean updateName(Long id, String newName);

}
