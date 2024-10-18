package com.franchise.project.service.product;

public interface ProductService {

    public boolean updateStock(Long id, int stock);
    public boolean updateName(Long id, String newName);
    
}
