package com.example.individual_backend.Services;

import com.example.individual_backend.Entity.Customer;
import com.example.individual_backend.Entity.Product;
import com.example.individual_backend.Pojo.Customer_pojo;

import java.io.IOException;
import java.util.List;

public interface Customer_service {

    String savecustomer(Customer_pojo customer_pojo) throws IOException;

    String updatecustomer(Customer_pojo customer_pojo) throws IOException;

    Customer_pojo findByUsername(String username);

    Customer findById(Integer id);
}
