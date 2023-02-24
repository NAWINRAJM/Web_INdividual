package com.example.individual_backend.Pojo;

import com.example.individual_backend.Entity.Order;
import com.example.individual_backend.Entity.Product;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order_pojo {
    private Integer O_id;
    private String pname;
    private String cname;
    private String price;
    private String quantity;
    private String address;
    private String contact;
    public Order_pojo(Order order){
        this.O_id=order.getO_id();
       this.address=order.getAddress();
       this.cname=order.getCname();
       this.pname= order.getPname();
       this.price=order.getPrice();
       this.contact=order.getContact();
       this.quantity= order.getQuantity();
    }
}
