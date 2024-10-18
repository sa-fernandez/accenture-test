package com.franchise.project.service.franchise;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.franchise.project.dto.ProductBranchDTO;
import com.franchise.project.models.Branch;
import com.franchise.project.models.Franchise;
import com.franchise.project.models.Product;
import com.franchise.project.repository.BranchRepository;
import com.franchise.project.repository.FranchiseRepository;

@Service
public class FranchiseServiceImpl implements FranchiseService {

    @Autowired
    private FranchiseRepository franchiseRepository;

    @Autowired
    private BranchRepository branchRepository;

    @Override
    public boolean addFranchise(String name) {
        try {
            franchiseRepository.save(new Franchise(name));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean addBranchToFranchise(Long id, Branch branch) {
        if (!franchiseRepository.existsById(id)) {
            return false;
        } 
        try {
            Franchise franchise = franchiseRepository.findById(id).orElseThrow();
            branch.setFranchise(franchise);
            branchRepository.save(branch);
            franchise.getBranches().add(branch);
            franchiseRepository.save(franchise);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public List<ProductBranchDTO> listMaxStock(Long id) {
        if (!franchiseRepository.existsById(id)) {
            return new ArrayList<>();
        }
        List<ProductBranchDTO> products = new ArrayList<>();
        try {
            Franchise franchise = franchiseRepository.findById(id).orElseThrow();
            List<Branch> branches = franchise.getBranches();
            for (Branch branch : branches) {
                ProductBranchDTO productFranchiseDTO = new ProductBranchDTO(null, -1, branch.getName());
                for (Product product : branch.getProducts()) {
                    if (product.getStock() > productFranchiseDTO.getStock()) {
                        productFranchiseDTO.setProductName(product.getName());
                        productFranchiseDTO.setStock(product.getStock());
                    }
                }
                products.add(productFranchiseDTO);
            }
        } catch (Exception e) {
            return new ArrayList<>();
        }
        return products;
    }

    @Override
    public boolean updateName(Long id, String newName) {
        if (!franchiseRepository.existsById(id)) {
            return false;
        } 
        try {
            Franchise franchise = franchiseRepository.findById(id).orElseThrow();
            franchise.setName(newName);
            franchiseRepository.save(franchise);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    
}
