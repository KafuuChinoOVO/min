package com.min.auth;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.min.model.system.SysRole;
import com.min.auth.mapper.SysRoleMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class TestMpDemo1 {

    //注入
    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Test
    public void getAll(){
        List<SysRole> list = sysRoleMapper.selectList(null);
        System.out.println(list);
    }

    @Test
    public void add(){
        SysRole role = new SysRole();
        role.setRoleName("角色管理员1");
        role.setRoleCode("role");
        role.setDescription("角色管理员1");
        int i = sysRoleMapper.insert(role);
        System.out.println(i);
        System.out.println(role.getId());
    }

    @Test
    public void update(){
        //通过id查询
        SysRole role = sysRoleMapper.selectById(10);
        //设置修改值
        role.setRoleName("chino");
        //调用方法实现修改
        sysRoleMapper.updateById(role);
    }

    @Test
    public void delete(){
        int i = sysRoleMapper.deleteById(2);
        System.out.println(i);
    }

    @Test
    public void deletes(){
        sysRoleMapper.deleteBatchIds(Arrays.asList(1,10));
    }

    @Test
    public void Query(){
        QueryWrapper<SysRole> wrapper = new QueryWrapper<>();
        wrapper.eq("role_name","chino");
        List<SysRole> list = sysRoleMapper.selectList(wrapper);
        System.out.println(list);
    }

    @Test
    public void Query1(){
        LambdaQueryWrapper<SysRole> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SysRole::getRoleName,"chino");
        List<SysRole> list = sysRoleMapper.selectList(wrapper);
        System.out.println(list);
    }
}
