package com.franchise.project.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.franchise.project.models.Product;
import com.franchise.project.requests.NameRequest;
import com.franchise.project.requests.ProductBranchRequest;
import com.franchise.project.service.branch.BranchService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/branch")
public class BranchController {

    @Autowired
    private BranchService branchService;

    @PostMapping(value = "/product_to_branch", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> addProductToBranch(@RequestBody ProductBranchRequest productBranchRequest) {
        Map<String, Object> response = new HashMap<>();
        if (branchService.addProductToBranch(productBranchRequest.getBranchId(), new Product(productBranchRequest.getProductName(), productBranchRequest.getProductStock()))) {
            response.put("success", true);
            response.put("message", "Product added to branch successfully");
            return ResponseEntity.ok().body(response);
        }
        response.put("success", false);
        response.put("message", "Failed to add product to branch");
        return ResponseEntity.internalServerError().body(response);
    }
    
    @PatchMapping(value = "/name", consumes = "application/json")
    public ResponseEntity<?> updateName(@RequestBody NameRequest nameRequest) {
        Map<String, Object> response = new HashMap<>();
        if (branchService.updateName(nameRequest.getId(), nameRequest.getName())) {
            response.put("success", true);
            response.put("message", "Branch name updated successfully");
            return ResponseEntity.ok().body(response);
        }
        response.put("success", false);
        response.put("message", "Failed to update branch name");
        return ResponseEntity.internalServerError().body(response);
    }
    
}
