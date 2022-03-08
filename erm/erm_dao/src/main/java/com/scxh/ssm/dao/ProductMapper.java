package com.scxh.ssm.dao;

import com.scxh.ssm.domain.Product;

import java.util.List;

public interface ProductMapper {
    public List<Product> findAll () throws  Exception;

    void save_add(Product product) throws  Exception;


    Product details(String id);

    void productUpdate(Product product) throws  Exception;

    void deleteProductById(String id) throws  Exception;
}
