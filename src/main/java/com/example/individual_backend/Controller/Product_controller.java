package com.example.individual_backend.Controller;

import com.example.individual_backend.Entity.Product;
import com.example.individual_backend.Pojo.Product_pojo;
import com.example.individual_backend.Services.Customer_service;
import com.example.individual_backend.Services.Product_service;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.List;

@Builder
@Controller
@RequiredArgsConstructor
@RequestMapping("/product")
public class Product_controller {
    private final Customer_service customer_service;
    private final Product_service product_service;
//    private final Pro;
    @GetMapping("/create")
    public String createProperty(Model model) {
        model.addAttribute("product", new Product_pojo());
        return "admin";
    }

    @PostMapping("/save")
    public String saveProduct(Product_pojo product_pojo) throws IOException {
        product_service.saveProduct(product_pojo);
        return "redirect:/admin/open";   //Write the pop box of sucess message
    }

    @GetMapping("/delete/{P_id}")
    public String deleteById(@PathVariable("P_id") Integer id){
        product_service.delteById(id);
        return "redirect:/admin/open";
    }

    @GetMapping("/edit/{P_id}")
    public String editUser(@PathVariable("P_id") Integer id,Model model){
        Product product =product_service.fetchById(id);
        model.addAttribute("product",new Product_pojo(product));
        return "admin";
    }
}
