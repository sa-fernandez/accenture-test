package com.franchise.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.franchise.project.models.Franchise;

@Repository
public interface FranchiseRepository extends JpaRepository <Franchise, Long> {
    
}
