package com.roman.dao;

import com.roman.entity.CartProduct;

import java.util.List;

public interface CartProductDAO {
    void createCartProduct(CartProduct cartProduct);
    CartProduct read(Long id);
    void updateCartProduct(CartProduct cartProduct);
    void deleteCartProduct(CartProduct cartProduct);
    List<CartProduct> findAll();

}
