package com.example.individual_backend.Repo;

import com.example.individual_backend.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Product_repo extends JpaRepository<Product, Integer> {

}
