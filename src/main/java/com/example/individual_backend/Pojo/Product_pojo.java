package com.example.individual_backend.Pojo;

import com.example.individual_backend.Entity.Product;
import jakarta.persistence.Transient;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product_pojo {

    private Integer P_id;
   private String productname;
   private String product_type;
   private String price;
    private MultipartFile image;

    public Product_pojo(Product product){
          this.P_id=product.getP_id();
          this.productname=product.getProductname();
          this.price=product.getPrice();
          this.product_type=product.getProduct_type();
    }

}
