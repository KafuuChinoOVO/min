package com.scxh.ssm.controller;


import com.github.pagehelper.PageInfo;
import com.scxh.ssm.domain.Product;
import com.scxh.ssm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService ps;

    //使用PageHelper查询所有商品并分页
    //PageHelper要求必须设置 pageNum起始页是第几页   pageSize每页显示多少行记录
    @RequestMapping("/findAll")
    public String findAll(Model model,
                          @RequestParam(value = "pageNum", required = true, defaultValue = "1") Integer pageNum,
                          @RequestParam(value = "pageSize", required = true, defaultValue = "5") Integer pageSize
    ) throws Exception {
        //根据起始页和每页显示的记录数查询所有商品
        List<Product> proList = ps.findAll(pageNum, pageSize);
        //分页模型封装  只需要三个内容就可以自动封装模型：pageNum，pageSize，商品集合
        PageInfo<Product> pageInfo = new PageInfo<>(proList);
        System.out.println("============" + pageInfo + "==============");
        model.addAttribute("pageInfo", pageInfo);
        return "product-list";
    }


    //添加
    @RequestMapping("/save")
    public String save(Product Product) throws Exception {
        String id = UUID.randomUUID().toString().replace("-", "");
        Product.setId(id);
        ps.save_add(Product);

        return "redirect:/product/findAll.do";
    }

    //    查询
    @RequestMapping("/findById")
    public String findById(String id, Model model) throws Exception {
        System.out.println("============" + id + "===========");
        Product product = ps.selectById(id);
        model.addAttribute("product", product);
        return "/product-details";
    }

    //修改
    @RequestMapping("/productDetails")
    public String selectUpdate(String id, Model model) throws Exception {
        Product product = ps.selectById(id);
        model.addAttribute("product", product);
        return "/product-update";
    }

    @RequestMapping("/productUpdate")
    public String productUpdate(Product product) throws Exception{
           ps.productUpdate(product);
        return "redirect:/product/findAll.do";
    }

    @RequestMapping("/deleteAll")
    public String deleteProduct(String[] ids) throws Exception{
        for (String id:ids) {
            ps.deleteProductById(id);
        }
        return "redirect:/product/findAll.do";
    }

}