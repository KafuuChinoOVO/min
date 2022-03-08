package com.scxh.ssm.controller;

import com.github.pagehelper.PageInfo;

import com.scxh.ssm.domain.Permission;
import com.scxh.ssm.domain.Role;
import com.scxh.ssm.domain.RoleVo;
import com.scxh.ssm.service.RoleService;
import com.scxh.ssm.service.impl.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService Rs;


    @RequestMapping("/findAll")
    public String findAll(Model model,
                          @RequestParam(value = "pageNum", required = true, defaultValue = "1") Integer pageNum,
                          @RequestParam(value = "pageSize", required = true, defaultValue = "5") Integer pageSize)
            throws Exception{
        List<Role> list = Rs.findAll(pageNum, pageSize);

        PageInfo<Role> pageInfo = new PageInfo<Role>(list);
        System.out.println("============" + pageInfo + "==============");
        model.addAttribute("pageInfo",pageInfo);
        return "role-list";
    }

    public RoleService getRs() {
        return Rs;
    }

    @RequestMapping("/save")
    public String save(Role role) throws  Exception{
        String id = UUID.randomUUID().toString().replace("-", "");
        role.setId(id);
        Rs.save_add(role);

        return "redirect:/role/findAll.do";
    }
    @RequestMapping("/findById")
    public String findById(String id,Model model) throws  Exception{
        RoleVo roleVo = Rs.findById(id);
//        System.out.println("============" + roleVo + "==============");
        model.addAttribute("roleVo",roleVo);

        return  "role-show";
    }

    @RequestMapping("/deleteRole")
    public String deleteRoleId(String id) throws  Exception{
//        System.out.println("============" + id + "==============");
        Rs.deleteRoleId(id);
        return  "redirect:/role/findAll.do";
    }
    @RequestMapping("/findRoleByIdAndAllPermission")
    public  String findRoleByIdAndAllPermission(String id,Model model) throws  Exception{
        List<Permission> permissionList=  Rs.findRoleByIdAndAllPermission(id);
//        for (Permission p: permissionList) {
//            System.out.println("============" + p + "==============");
//        }

        model.addAttribute("permissionList",permissionList);
        model.addAttribute("setId",id);

        return "role-permission-add";
    }
    @RequestMapping("/addPermissionToRole")
    public String addPermissionToRole(String[] ids,String setId  ) throws  Exception{
        for (String  id:ids) {
            Rs.addPermissionToRole(id,setId);
        }
        return "redirect:/role/findAll.do";
    }
}
