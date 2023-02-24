package com.example.individual_backend.Entity;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "buy")
public class Order {
    @Id
    @SequenceGenerator(name = "gp_user_seq_gen", sequenceName = "gp_user_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "gp_user_seq_gen", strategy = GenerationType.SEQUENCE)
    private Integer O_id;

    @Column(nullable = false)
    private String cname;

    @Column(nullable = false)
    private String pname;

    @Column(nullable = false)
    private String price;

    @Column(nullable = false)
    private String contact;

    @Column(nullable = false)
    private String quantity;

    @Column(nullable = false)
    private String address;

}
