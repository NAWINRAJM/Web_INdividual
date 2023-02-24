package com.example.individual_backend.Services.Impl;

import com.example.individual_backend.Entity.Order;
import com.example.individual_backend.Pojo.Customer_pojo;
import com.example.individual_backend.Pojo.Order_pojo;
import com.example.individual_backend.Repo.Order_repo;
import com.example.individual_backend.Services.Order_service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class Order_serviceimpl implements Order_service {
    private final Order_repo order_repo;

    @Override
    public void saveProduct(Order_pojo order_pojo) {
        Order order =new Order();
        order.setAddress(order_pojo.getAddress());
        order.setPrice(order_pojo.getPrice());
        order.setCname(order_pojo.getCname());
        order.setContact(order_pojo.getContact());
        order.setPname(order_pojo.getPname());
        order.setQuantity(order_pojo.getQuantity());
        order_repo.save(order);

    }

    @Override
    public List<Order> fetchAll() {
        return order_repo.findAll();
    }

    @Override
    public void delteById(Integer id) {
        order_repo.deleteById(id);
    }
}
