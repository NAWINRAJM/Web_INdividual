package com.example.individual_backend.Repo;

import com.example.individual_backend.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Order_repo extends JpaRepository<Order,Integer> {
}
