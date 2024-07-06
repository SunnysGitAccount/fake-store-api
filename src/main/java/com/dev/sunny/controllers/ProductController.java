package com.dev.sunny.controllers;

import com.dev.sunny.entities.Product;
import com.dev.sunny.mappers.ProductMapper;
import com.dev.sunny.model.ProductDTO;
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
    private final ProductMapper mapper;

    @PostMapping({"/create", "/new"})
    public Product createNewProduct(ProductDTO productDTO) {
        log.info("Create new product: {}", productDTO);

        Product savedProduct = restTemplate.postForObject("https://fakestoreapi.com/products", productDTO, Product.class);

        if (savedProduct == null) return new Product();

        return savedProduct;
    }

    @GetMapping("/all")
    public List<ProductDTO> getAllProducts() {
        Product[] fetchedProducts = restTemplate.getForObject("https://fakestoreapi.com/products", Product[].class);
        List<Product> products = fetchedProducts != null ? List.of(fetchedProducts) : new ArrayList<>();

        log.info("Fetched products: {}", products);
        return products.stream()
                .map(mapper::productToProductDTO)
                .toList();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable("id") Long productId) {
        log.info("Delete product with productId: {}", productId);

        restTemplate.delete("https://fakestoreapi.com/products/" + productId);
    }

}
