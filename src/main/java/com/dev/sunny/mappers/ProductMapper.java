package com.dev.sunny.mappers;

import com.dev.sunny.entities.Product;
import com.dev.sunny.model.ProductDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface ProductMapper {
    @Mapping(target = "id", ignore = true)
    Product productDTOToProduct(ProductDTO productDTO);
    ProductDTO productToProductDTO(Product product);
}
