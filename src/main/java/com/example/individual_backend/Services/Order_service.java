package com.example.individual_backend.Services;

import com.example.individual_backend.Entity.Order;
import com.example.individual_backend.Pojo.Customer_pojo;
import com.example.individual_backend.Pojo.Order_pojo;

import java.util.List;

public interface Order_service {
    void saveProduct(Order_pojo order_pojo);

    List<Order> fetchAll();

    void delteById(Integer id);
}
