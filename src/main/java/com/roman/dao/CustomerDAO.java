package com.roman.dao;

import com.roman.entity.Customer;

import java.util.List;

public interface CustomerDAO {
    void create(Customer customer);
    Customer read(Long id);
    void updateCustomer(Customer customer);
    void deleteCustomer(Customer customer);
    List<Customer> findAll();

 }
