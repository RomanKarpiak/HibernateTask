package com.roman.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "cart_product")
public class CartProduct implements Serializable {

    @Id
    @Column(name = "cart_id")
    private Long cart_id;

    @Id
    @Column(name = "product_id")
    private Long product_id;

    public CartProduct() {
    }

    public Long getCart_id() {
        return cart_id;
    }

    public void setCart_id(Long cart_id) {
        this.cart_id = cart_id;
    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    @Override
    public String toString() {
        return String.format("%-10d%-10d\n",cart_id,product_id);
    }
}
