package com.dev.sunny.model;

import lombok.Data;

@Data
public class Product {
    private Long id;
    private String title;
    private Double price;
    private String category;
    private String description;
    private String image;
}
