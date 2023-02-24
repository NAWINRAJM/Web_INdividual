package com.example.individual_backend.Pojo;

import com.example.individual_backend.Entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer_pojo {
    private Integer id;
    private String fullname;
    private String username;
    private String password;
    private MultipartFile image;
    private String image1;
    private String imageBase64;
    public Customer_pojo(Customer customer){
        this.id= customer.getId();
        this.fullname= customer.getFullname();
        this.password= customer.getPassword();
        this.username= customer.getUsername();
        this.image1=customer.getImage();
        this.imageBase64= customer.getImageBase64();
    }
}
