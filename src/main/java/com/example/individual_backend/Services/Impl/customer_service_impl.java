package com.example.individual_backend.Services.Impl;

import com.example.individual_backend.Entity.Customer;
import com.example.individual_backend.Pojo.Customer_pojo;
import com.example.individual_backend.Repo.Customer_repo;
import com.example.individual_backend.Services.Customer_service;
import com.example.individual_backend.exception.Appexception;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
@RequiredArgsConstructor
public class customer_service_impl implements Customer_service {

    public final Customer_repo customer_repo;
    public static String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/Customer";

    @Override
    public String savecustomer(Customer_pojo customer_pojo) throws IOException {
        Customer customer;
        if (customer_pojo.getId()!=null) {
            System.out.println("Edit");
            customer = customer_repo.findById(customer_pojo.getId()).orElseThrow(() -> new RuntimeException("Not Found"));
            customer.setPassword(customer_pojo.getPassword());
        } else {
            System.out.println("create");
            customer = new Customer();
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String encodedPassword = passwordEncoder.encode(customer_pojo.getPassword());
            customer.setPassword(encodedPassword);
        }
        customer.setFullname(customer_pojo.getFullname());
        customer.setUsername(customer_pojo.getUsername());
        if(customer_pojo.getImage() != null && !customer_pojo.getImage().isEmpty()){
            System.out.println(customer.getImage());
            StringBuilder fileNames = new StringBuilder();
            System.out.println(UPLOAD_DIRECTORY);
            Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY, customer_pojo.getImage().getOriginalFilename());
            fileNames.append(customer_pojo.getImage().getOriginalFilename());
            Files.write(fileNameAndPath, customer_pojo.getImage().getBytes());
            customer.setImage(customer_pojo.getImage().getOriginalFilename());
        }else {
            customer.setImage("default-avatar-profile-icon-vector-39013212.jpg");
        }
        customer_repo.save(customer);
        return "created";
    }

    @Override
    public String updatecustomer(Customer_pojo customer_pojo) throws IOException {
        Customer customer;
            System.out.println("Edit");
            customer = customer_repo.findById(customer_pojo.getId()).orElseThrow(() -> new RuntimeException("Not Found"));
            customer.setPassword(customer_pojo.getPassword());

        customer.setFullname(customer_pojo.getFullname());
        customer.setUsername(customer_pojo.getUsername());
        if(customer_pojo.getImage() != null && !customer_pojo.getImage().isEmpty()){
            System.out.println(customer.getImage());
            StringBuilder fileNames = new StringBuilder();
            System.out.println(UPLOAD_DIRECTORY);
            Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY, customer_pojo.getImage().getOriginalFilename());
            fileNames.append(customer_pojo.getImage().getOriginalFilename());
            Files.write(fileNameAndPath, customer_pojo.getImage().getBytes());
            customer.setImage(customer_pojo.getImage().getOriginalFilename());
        }else {
            customer.setImage(customer.getImage());
        }
        customer_repo.save(customer);
        return "created";
    }


    @Override
    public Customer_pojo findByUsername(String username) {
        Customer customer=customer_repo.findByUsername(username).orElseThrow(() ->new Appexception("Invalid Username", HttpStatus.BAD_REQUEST));
        return new Customer_pojo(customer);
    }

    @Override
    public Customer findById(Integer id) {
        return customer_repo.findById(id).orElseThrow(()->new RuntimeException("Not Found"));
    }

}
