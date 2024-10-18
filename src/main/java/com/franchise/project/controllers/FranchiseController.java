package com.franchise.project.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.franchise.project.dto.ProductBranchDTO;
import com.franchise.project.models.Branch;
import com.franchise.project.requests.BranchFranchiseRequest;
import com.franchise.project.requests.NameRequest;
import com.franchise.project.requests.NewObjectRequest;
import com.franchise.project.service.franchise.FranchiseService;
import org.springframework.web.bind.annotation.GetMapping;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/franchise")
public class FranchiseController {

    @Autowired
    private FranchiseService franchiseService;

    @PostMapping(value = "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> addFranchise(@RequestBody NewObjectRequest newObjectRequest) {
        Map<String, Object> response = new HashMap<>();
        if (franchiseService.addFranchise(newObjectRequest.getName())) {
            response.put("success", true);
            response.put("message", "Franchise added successfully");
            return ResponseEntity.ok().body(response);
        }
        response.put("success", false);
        response.put("message", "Failed to add franchise");
        return ResponseEntity.internalServerError().body(response);
    }

    @PostMapping(value = "/branch_to_franchise", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> addBranchToFranchise(@RequestBody BranchFranchiseRequest branchFranchiseRequest) {
        Map<String, Object> response = new HashMap<>();
        if (franchiseService.addBranchToFranchise(branchFranchiseRequest.getFranchiseId(), new Branch(branchFranchiseRequest.getBranchName()))) {
            response.put("success", true);
            response.put("message", "Branch added to franchise successfully");
            return ResponseEntity.ok().body(response);
        }
        response.put("success", false);
        response.put("message", "Failed to add branch to franchise");
        return ResponseEntity.internalServerError().body(response);
    }

    @GetMapping("/max_stock_per_branch/{id_franchise}")
    public ResponseEntity<?> getMaxStockPerBranch(@PathVariable("id_franchise") Long id) {
        Map<String, Object> response = new HashMap<>();
        List<ProductBranchDTO> products = franchiseService.listMaxStock(id);
        if (!products.isEmpty()) {
            response.put("success", true);
            response.put("message", products);
            return ResponseEntity.ok().body(response);
        }
        response.put("success", false);
        response.put("message", "Failed to retrieve max stock products per branch");
        return ResponseEntity.internalServerError().body(response);
    }
    
    @PatchMapping(value = "/name", consumes = "application/json")
    public ResponseEntity<?> updateName(@RequestBody NameRequest nameRequest) {
        Map<String, Object> response = new HashMap<>();
        if (franchiseService.updateName(nameRequest.getId(), nameRequest.getName())) {
            response.put("success", true);
            response.put("message", "Franchise name updated successfully");
            return ResponseEntity.ok().body(response);
        }
        response.put("success", false);
        response.put("message", "Failed to update franchise name");
        return ResponseEntity.internalServerError().body(response);
    }
    
}
