package com.example.individual_backend.Repo;

import com.example.individual_backend.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface Customer_repo extends JpaRepository<Customer,Integer> {

    @Query(value = "select * from CUSTOMER where username=?1",nativeQuery = true)
    Optional<Customer> findByUsername(String username);
}
