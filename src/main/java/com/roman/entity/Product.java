package com.roman.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "price")
    private int price;

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "productId")
    private List<ProductPhoto> productPhotos = new ArrayList<>();

    @ManyToMany(mappedBy = "products")
    private Set<Cart> carts =new HashSet<>();
    public Product() {
    }

    public Product(String name, String description, int price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public List<ProductPhoto> getProductPhotos() {
        return productPhotos;
    }

    public void setProductPhotos(List<ProductPhoto> productPhotos) {
        this.productPhotos = productPhotos;
    }

    public Set<Cart> getCarts() {
        return carts;
    }

    public void setCarts(Set<Cart> carts) {
        this.carts = carts;
    }

    @Override
    public String toString() {
        return String.format("%-5d%-20s%-20s%-10d\n",id,name,description,price);
    }
}
