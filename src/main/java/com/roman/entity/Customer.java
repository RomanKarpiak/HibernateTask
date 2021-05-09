package com.roman.entity;

import javax.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "phone")
    private String phone;
    @Column(name = "email")
    private String email;

    @OneToOne(mappedBy = "customer")
    private Cart cart;

    @Embedded
    @AttributeOverrides(value = {
            @AttributeOverride(name="country", column = @Column(name = "country")),
            @AttributeOverride(name="city",column = @Column(name = "city")),
            @AttributeOverride(name = "street",column = @Column(name = "street"))
    })
    private Address address;


    public Customer() {
    }

    public Customer(String name, String phone, String email, Cart cart, Address address) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.cart = cart;
        this.address = address;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return String.format("%-10d%-10s%-10s%-10s%-10s\n",id,name,phone,email,address);
    }
}


