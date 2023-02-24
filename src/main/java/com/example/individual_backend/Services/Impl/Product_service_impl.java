package com.example.individual_backend.Services.Impl;

import com.example.individual_backend.Entity.Product;
import com.example.individual_backend.Pojo.Product_pojo;
import com.example.individual_backend.Repo.Product_repo;
import com.example.individual_backend.Services.Product_service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
@RequiredArgsConstructor
public class Product_service_impl  implements Product_service {
    public final Product_repo product_repo;
    public static String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/House";
    @Override
    public String saveProduct(Product_pojo product_pojo) throws IOException {
        Product product;
        if (product_pojo.getP_id() != null) {
            System.out.println("edit");
            product = product_repo.findById(product_pojo.getP_id()).orElseThrow(() -> new RuntimeException("Not Found"));
        } else {
            System.out.println("create");
            product = new Product();
        }
        product.setProduct_type(product_pojo.getProduct_type());
        product.setProductname(product_pojo.getProductname());
        product.setPrice(product_pojo.getPrice());
//        System.out.println(product_pojo.getImage().getOriginalFilename());
        if(!product_pojo.getImage().isEmpty()){
            System.out.println(product_pojo.getImage());
            StringBuilder fileNames = new StringBuilder();
            System.out.println(UPLOAD_DIRECTORY);
            Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY, product_pojo.getImage().getOriginalFilename());
            fileNames.append(product_pojo.getImage().getOriginalFilename());
            Files.write(fileNameAndPath, product_pojo.getImage().getBytes());
            product.setImage(product_pojo.getImage().getOriginalFilename());
        }

        product_repo.save(product);
        return "created";
    }

    @Override
    public List<Product> fetchAll() {
        return product_repo.findAll();
    }

    @Override
    public void delteById(Integer id) {
               product_repo.deleteById(id);
    }

    @Override
    public Product fetchById(Integer id) {
        return product_repo.findById(id).orElseThrow(()->new RuntimeException("Not Found"));
    }
}
