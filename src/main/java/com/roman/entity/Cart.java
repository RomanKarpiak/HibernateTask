package com.roman.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "customer_id",referencedColumnName = "id")
    private Customer customer;

    @ManyToMany
    @JoinTable(name = "cart_product",
               joinColumns = @JoinColumn(name = "cart_id",referencedColumnName = "id"),
               inverseJoinColumns = @JoinColumn(name = "product_id",referencedColumnName = "id")
    )
    private Set<Product> products = new HashSet<>();

    public Cart() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return String.format("%-10d%-10s\n",id, customer);
    }
}
