package com.example.individual_backend.Controller;

import com.example.individual_backend.Entity.Customer;
import com.example.individual_backend.Pojo.Customer_pojo;
import com.example.individual_backend.Services.Customer_service;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.security.Principal;
import java.util.Base64;

@Builder
@Controller
@RequiredArgsConstructor
@RequestMapping("/profile")
public class profilecontroller {
    private final Customer_service customer_service;
    @GetMapping("/open/{id}")
    public String open(@PathVariable("id") Integer id,Model model, Principal principal){
        Customer customer=customer_service.findById(id);
        customer.setImageBase64(getImageBase64(customer.getImage()));
        model.addAttribute("logged", new Customer_pojo(customer));
        return "profile";
    }

    @GetMapping("/edit/{id}")
    public String openep(@PathVariable("id") Integer id, Principal principal, Model model){
       Customer customer=customer_service.findById(id);
       customer.setImageBase64(getImageBase64(customer.getImage()));
        model.addAttribute("logged",new Customer_pojo(customer));
        return "editprofile";
    }

    public String getImageBase64(String fileName) {
        String filePath = System.getProperty("user.dir") + "/Customer/";
        File file = new File(filePath + fileName);
        byte[] bytes = new byte[0];
        try {
            bytes = Files.readAllBytes(file.toPath());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        String base64 = Base64.getEncoder().encodeToString(bytes);
        return base64;
    }
    @PostMapping("/save")
    public String updateuser(Customer_pojo customer_pojo) throws IOException {
        customer_service.updatecustomer(customer_pojo);
        return "login";
    }
}
