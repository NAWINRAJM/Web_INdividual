package com.example.individual_backend.Services;

import com.example.individual_backend.Entity.Product;
import com.example.individual_backend.Pojo.Product_pojo;

import java.io.IOException;
import java.util.List;

public interface Product_service {
    String saveProduct(Product_pojo product_pojo) throws IOException;

    List<Product> fetchAll();

    void delteById(Integer id);

    Product fetchById(Integer id);
}
