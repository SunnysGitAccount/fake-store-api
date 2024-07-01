package com.dev.sunny.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "product_data")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id")
    private Long id;

    @Column(name = "product_title", length = 50)
    private String title;

    @Column(name = "product_price")
    private Double price;

    @Column(name = "product_category", length = 20)
    private String category;

    @Column(name = "product_description", length = 500)
    private String description;

    @Column(name = "image_url", length = 1024)
    private String image;
}
