package com.roman.dao;

import com.roman.entity.Product;

import java.util.List;

public interface ProductDAO {
    void create(Product product);

    Product read(Long id);

    void updateProduct(Product product);

    void deleteProduct(Product product);

    List<Product> findAll();
}
