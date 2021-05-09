package com.roman.dao;

import com.roman.entity.Cart;

import java.util.List;

public interface CartDAO {
    void create(Cart cart);
    Cart read(Long id);
    void updateCart(Cart cart);
    void deleteCart(Cart cart);
    List<Cart> findAll();


}
