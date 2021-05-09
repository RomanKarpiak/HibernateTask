package com.roman.dao;

import com.roman.entity.ProductPhoto;

import java.util.List;

public interface ProductPhotoDao {
    void create(ProductPhoto productPhoto);

    ProductPhoto read(Long id);

    void updateProductPhoto(ProductPhoto productPhoto);

    void deleteProductPhoto(ProductPhoto productPhoto);

    List<ProductPhoto> findAll();


}
