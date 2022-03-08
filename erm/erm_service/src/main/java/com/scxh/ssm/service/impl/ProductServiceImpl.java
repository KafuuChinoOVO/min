package com.scxh.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.scxh.ssm.dao.ProductMapper;
import com.scxh.ssm.domain.Product;
import com.scxh.ssm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper pm;

    @Override
    public List<Product> findAll(Integer pageNum,Integer pageSize) throws Exception {
//        在业务层进行分页封装
        //1、PageHelper.startPage(pageNum, pageSize);
        PageHelper.startPage(pageNum,pageSize);
        //2、紧跟着必须是查询语句
        List<Product> proList = pm.findAll();
        return proList;
    }

    @Override
    public void save_add(Product product) throws Exception {
        pm.save_add(product);
    }

    @Override
    public Product selectById(String id) {
         return  pm.details((id));
    }

    @Override
    public void productUpdate(Product product) throws Exception {
        pm.productUpdate(product);
    }

    @Override
    public void deleteProductById(String id) throws Exception {
        pm.deleteProductById(id);
    }

}
