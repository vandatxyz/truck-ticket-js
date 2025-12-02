package com.anoystick.controller;

import com.anoystick.entity.ProductEntity;
import com.anoystick.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api")
//localhost:8080/v1/api
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/product/add")
    public ProductEntity createProduct(@RequestBody ProductEntity productEntity) {
        return productService.createProduct(productEntity);
    }

    @GetMapping("/products")
    public List<ProductEntity> findAllProducts() {
        return productService.findAll();
    }

}
