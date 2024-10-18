package com.franchise.project.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.franchise.project.requests.NameRequest;
import com.franchise.project.requests.StockRequest;
import com.franchise.project.service.product.ProductService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PatchMapping(value = "/stock", consumes = "application/json")
    public ResponseEntity<?> updateStock(@RequestBody StockRequest stockRequest) {
        Map<String, Object> response = new HashMap<>();
        if (productService.updateStock(stockRequest.getId(), stockRequest.getStock())) {
            response.put("success", true);
            response.put("message", "Product stock updated successfully");
            return ResponseEntity.ok().body(response);
        }
        response.put("success", false);
        response.put("message", "Failed to update product stock");
        return ResponseEntity.internalServerError().body(response);
    }

    @PatchMapping(value = "/name", consumes = "application/json")
    public ResponseEntity<?> updateName(@RequestBody NameRequest nameRequest) {
        Map<String, Object> response = new HashMap<>();
        if (productService.updateName(nameRequest.getId(), nameRequest.getName())) {
            response.put("success", true);
            response.put("message", "Product name updated successfully");
            return ResponseEntity.ok().body(response);
        }
        response.put("success", false);
        response.put("message", "Failed to update product name");
        return ResponseEntity.internalServerError().body(response);
    }
    
}
