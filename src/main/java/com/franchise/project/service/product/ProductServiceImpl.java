package com.franchise.project.service.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.franchise.project.models.Product;
import com.franchise.project.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    
    @Override
    public boolean updateStock(Long id, int stock) {
        if (productRepository.existsById(id)) {
            Product product = productRepository.findById(id).orElseThrow();
            product.setStock(stock);
            productRepository.save(product);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean updateName(Long id, String newName) {
        if (!productRepository.existsById(id)) {
            return false;
        }
        try {
            Product product = productRepository.findById(id).orElseThrow();
            product.setName(newName);
            productRepository.save(product);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    
}
