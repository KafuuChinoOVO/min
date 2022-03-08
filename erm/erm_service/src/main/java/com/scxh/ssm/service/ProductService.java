package com.scxh.ssm.service;

import com.scxh.ssm.domain.Product;

import java.util.List;

public interface ProductService {




    public List<Product> findAll(Integer pageNum, Integer pageSize) throws  Exception;

    void save_add(Product product) throws  Exception;


    Product selectById(String id);

    void productUpdate(Product product) throws  Exception;

    void deleteProductById(String id) throws  Exception;
}
