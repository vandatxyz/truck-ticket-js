package com.anoystick.repository.impl;

import com.anoystick.entity.ProductEntity;
import com.anoystick.repository.ProductRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
    @Override
    public ProductEntity createProduct(ProductEntity product) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setId(1L);
        productEntity.setProductName("Tip JAVA");
        productEntity.setProductPrice(new BigDecimal("21.6"));
        return productEntity;
    }

    @Override
    public List<ProductEntity> findAll() {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setId(1L);
        productEntity.setProductName("Tip JAVA");
        productEntity.setProductPrice(new BigDecimal("21.6"));
        return List.of(productEntity);
    }
}
