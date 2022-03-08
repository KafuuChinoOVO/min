package com.scxh.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.scxh.ssm.domain.Permission;
import com.scxh.ssm.domain.Product;
import com.scxh.ssm.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/permission")
public class PermissionController {
    @Autowired
    private PermissionService ps;

    @RequestMapping("/findAll")
    public String findAll(Model model,
                          @RequestParam(value = "pageNum", required = true, defaultValue = "1") Integer pageNum,
                          @RequestParam(value = "pageSize", required = true, defaultValue = "5") Integer pageSize)
            throws Exception{
        List<Permission> list = ps.findAll(pageNum, pageSize);

        PageInfo<Permission> pageInfo = new PageInfo<Permission>(list);
        System.out.println("============" + pageInfo + "==============");
        model.addAttribute("pageInfo",pageInfo);
        return "permission-list";
    }
    @RequestMapping("/findById")
    public String findById(String id,Model model) throws  Exception{
          Permission permission = ps.findById(id);
          model.addAttribute("permission",permission);
        return "permission-show";
    }
    @RequestMapping("/save")
    public String save(Permission permission) throws Exception {
        String id = UUID.randomUUID().toString().replace("-", "");
        permission.setId(id);
        ps.save_add(permission);

        return "redirect:/permission/findAll.do";
    }
    @RequestMapping("/deletePermission")
    public  String deletePermissionId(String id) throws  Exception{
        ps.deletePermissionId(id);
        return "redirect:/permission/findAll.do";
    }
}
