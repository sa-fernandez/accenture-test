package com.franchise.project.service.branch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.franchise.project.models.Branch;
import com.franchise.project.models.Product;
import com.franchise.project.repository.BranchRepository;
import com.franchise.project.repository.ProductRepository;

@Service
public class BranchServiceImpl implements BranchService {

    @Autowired
    private BranchRepository branchRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public boolean addProductToBranch(Long id, Product product) {
        System.out.println("alo");
        if (!branchRepository.existsById(id)) {
            return false;
        }
        try {
            Branch branch = branchRepository.findById(id).orElseThrow();
            product.setBranch(branch);
            productRepository.save(product);
            branch.getProducts().add(product);
            branchRepository.save(branch);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean updateName(Long id, String newName) {
        if (!branchRepository.existsById(id)) {
            return false;
        }
        try {
            Branch branch = branchRepository.findById(id).orElseThrow();
            branch.setName(newName);
            branchRepository.save(branch);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    
}
