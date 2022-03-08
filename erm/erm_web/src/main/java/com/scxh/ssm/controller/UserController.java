package com.scxh.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.scxh.ssm.domain.Permission;
import com.scxh.ssm.domain.Role;
import com.scxh.ssm.domain.UserInfo;
import com.scxh.ssm.service.UserService;
import com.scxh.ssm.uitls.BCryptPasswordEncoderUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService us;

    @RequestMapping("/findAll")
    public String findAll(Model model,
                          @RequestParam(value = "pageNum", required = true, defaultValue = "1") Integer pageNum,
                          @RequestParam(value = "pageSize", required = true, defaultValue = "5") Integer pageSize)
            throws Exception{
        List<UserInfo> list = us.findAll(pageNum, pageSize);

        PageInfo<UserInfo> pageInfo = new PageInfo<UserInfo>(list);
        System.out.println("============" + pageInfo + "==============");
        model.addAttribute("pageInfo",pageInfo);
        return "user-list";
    }


    @RequestMapping("/save")
    public String save(UserInfo userInfo) throws  Exception{
        String id = UUID.randomUUID().toString().replace("-", "");
        userInfo.setId(id);
//        System.out.println("============" + userInfo + "==============");
        String password = userInfo.getPassword();
        String new_password = BCryptPasswordEncoderUtils.encodePassword(password);
        userInfo.setPassword(new_password);
        us.save_add(userInfo);

        return "redirect:/user/findAll.do";
    }


    @RequestMapping("/findById")
    public String findById(String id,Model model) throws  Exception{
        UserInfo userInfo = us.findById(id);
        List<Role> roles = us.findRoleByUserId(id);
        System.out.println("=======rrrrrr=====" + roles + "==============");
        for (Role  role:roles) {
               List<Permission> permissions = us.findPermissionByRoleId(role.getId());
            System.out.println("========pppppp====" + permissions + "==============");
            role.setPermissions(permissions);
        }
        userInfo.setRoles(roles);

        model.addAttribute("user",userInfo);
        return "user-show" ;
    }

    @RequestMapping("/findUserByIdAndAllRole")
    public String findUserByIdAndAllRole(String id,Model model) throws  Exception{
        List<Role> role = us.findUserByIdAndAllRole(id);
        model.addAttribute("userId",id);
        model.addAttribute("roleList",role);
        return "/user-role-add";
    }
    @RequestMapping("/addRoleToUser")
    public  String addRoleToUser(String[] ids,String userId) throws  Exception{
        for (String  id: ids) {
            us.addRoleToUser(id,userId);
        }
        return "redirect:/user/findAll.do";
    }
}
