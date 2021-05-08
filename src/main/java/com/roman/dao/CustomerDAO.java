package com.roman.dao;

import com.roman.entity.Customer;

import java.util.List;

public interface CustomerDAO {
    void create(Customer customer);
    Customer read(Long id);
    void updateClient(Customer customer);
    void deleteClient(Customer customer);
    List<Customer> findAll();

 }
