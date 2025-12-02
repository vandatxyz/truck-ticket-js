package com.anoystick.service.impl;

import com.anoystick.entity.ProductEntity;
import com.anoystick.repository.ProductRepository;
import com.anoystick.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public ProductEntity createProduct(ProductEntity productEntity) {
        return productRepository.createProduct(productEntity);
    }

    @Override
    public List<ProductEntity> findAll() {
        return productRepository.findAll();
    }
}
