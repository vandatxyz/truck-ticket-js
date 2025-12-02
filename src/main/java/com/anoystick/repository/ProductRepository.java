package com.anoystick.repository;

import com.anoystick.entity.ProductEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository {

    ProductEntity createProduct(ProductEntity productEntity);

    List<ProductEntity> findAll();
}
