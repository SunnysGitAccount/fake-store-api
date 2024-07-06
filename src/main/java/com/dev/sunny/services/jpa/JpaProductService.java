package com.dev.sunny.services.jpa;

import com.dev.sunny.services.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
@Slf4j
public class JpaProductService implements ProductService {

    public JpaProductService() {
        log.info("JpaProductService bean created!");
    }

}
