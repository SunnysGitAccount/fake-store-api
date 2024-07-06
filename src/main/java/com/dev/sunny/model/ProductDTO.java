package com.dev.sunny.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductDTO {
    private String title;
    private Double price;
    private String category;
    private String description;
    private String image;
}
