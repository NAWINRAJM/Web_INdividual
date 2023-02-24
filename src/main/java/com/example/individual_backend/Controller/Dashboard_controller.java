package com.example.individual_backend.Controller;

import com.example.individual_backend.Entity.Product;
import com.example.individual_backend.Services.Customer_service;
import com.example.individual_backend.Services.Product_service;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.security.Principal;
import java.util.Base64;
import java.util.Collection;
import java.util.List;

@Builder
@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class Dashboard_controller {
    private final Product_service product_service;
    private final Customer_service customer_service;

    @GetMapping("/create")    //This is for admin side to view teams and update delete
    public String getPropertyList(Model model, Authentication authentication, Principal principal) {
            if (authentication!=null){
                Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
                for (GrantedAuthority grantedAuthority : authorities) {
                    if (grantedAuthority.getAuthority().equals("Admin")) {
                        return "redirect:/admin/open";
                    }
                }
            }
        List<Product> property = product_service.fetchAll();
        model.addAttribute("productList", property.stream().map(user ->
                Product.builder()
                        .P_id(user.getP_id())
                        .imageBase64(getImageBase64(user.getImage()))
                        .price(user.getPrice())
                        .product_type(user.getProduct_type())
                        .productname(user.getProductname())
                        .build()
        ));
        model.addAttribute("logged",customer_service.findByUsername(principal.getName()));
        return "Dashhhboard";
    }
    public String getImageBase64(String fileName) {
        String filePath = System.getProperty("user.dir") + "/House/";
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
//    @GetMapping("/open")
//    public String go(Model model){
//        List<Product> property = product_service.fetchAll();
//        model.addAttribute("productList", property.stream().map(user ->
//                Product.builder()
//                        .P_id(user.getP_id())
//                        .imageBase64(getImageBase64(user.getImage()))
//                        .price(user.getPrice())
//                        .product_type(user.getProduct_type())
//                        .productname(user.getProductname())
//                        .build()
//        ));
//            return "mainAdmin";
//
//    }
}
