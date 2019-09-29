package com.ripcitysoftware.productservice;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products/{id}")
    @CrossOrigin
    @ResponseBody
    public Product getProduct(@PathVariable("id") Long id) {
        log.info("/products/{} invoked!", id);
        return productService.findProduct(id);
    }
}

@Service
class ProductService {
    public Product findProduct(Long id) {
        return Product.builder()
                .id(1L)
                .name("Tide Original")
                .build();
    }
}

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
class Product {
    private Long id;
    private String name;
}


