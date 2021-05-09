package com.roman.dao;

import com.roman.entity.Address;

import java.util.List;

public interface AddressDAO {
    void create(Address address);
    Address read(Long id);
    void updateAddress(Address address);
    void deleteAddress(Address address);
    List<Address> findAll();
}
