package com.example.individual_backend.Controller;

import com.example.individual_backend.Pojo.Customer_pojo;
import com.example.individual_backend.Services.Customer_service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
@RequestMapping("/customer")
public class Registration_Controller {
    private final Customer_service customer_service;

    @GetMapping("/add")
    public String addcustomer(Model model){
        model.addAttribute("customer",new Customer_pojo());
        return "signup";
    }

    @PostMapping("/save")
    public String saveuser(Customer_pojo customer_pojo) throws IOException {
        customer_service.savecustomer(customer_pojo);
        return "login";
    }

}
