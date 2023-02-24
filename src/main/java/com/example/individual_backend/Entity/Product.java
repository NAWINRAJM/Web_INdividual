package com.example.individual_backend.Entity;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Product{
    @Id
    @SequenceGenerator(name = "gp_user_seq_gen", sequenceName = "gp_user_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "gp_user_seq_gen", strategy = GenerationType.SEQUENCE)
    private Integer P_id;

    @Column(nullable = false)
    private String productname;

    @Column(nullable = false)
    private String price;

    @Column(nullable = false)
    private String product_type;



    private String image;

    @Transient
    private String imageBase64;


}
