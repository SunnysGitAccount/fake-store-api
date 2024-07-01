package com.dev.sunny.controllers;

import com.dev.sunny.model.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/products/api")
@RequiredArgsConstructor
public class ProductController {

    private final RestTemplate restTemplate;

    @PostMapping({"/create", "/new"})
    public Product createNewProduct(Product product) {
        log.info("Create new product: {}", product);

        restTemplate.postForObject("https://fakestoreapi.com/products", product, Product.class);
        return product;
    }

    @GetMapping("/all")
    public List<Product> getAllProducts() {
        Product[] fetchedProducts = restTemplate.getForObject("https://fakestoreapi.com/products", Product[].class);
        List<Product> products = fetchedProducts != null ? List.of(fetchedProducts) : new ArrayList<>();

        log.info("Fetched products: {}", products);
        return products;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable("id") Long productId) {
        log.info("Delete product with productId: {}", productId);

        restTemplate.delete("https://fakestoreapi.com/products/" + productId);
    }

}
