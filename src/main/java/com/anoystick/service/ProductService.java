package com.anoystick.service;

import com.anoystick.entity.ProductEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    ProductEntity createProduct(ProductEntity productEntity);

    List<ProductEntity> findAll();

}
