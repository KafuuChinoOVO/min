package com.scxh.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.scxh.ssm.dao.RoleMapper;

import com.scxh.ssm.domain.Permission;
import com.scxh.ssm.domain.Role;
import com.scxh.ssm.domain.RoleVo;
import com.scxh.ssm.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper Rm;

    @Override
    public List<Role> findAll(Integer pageNum, Integer pageSize) throws Exception {
        PageHelper.startPage(pageNum,pageSize);
        List<Role> list = Rm.findAll();
        return list;

    }

    @Override
    public void save_add(Role role) throws Exception {
        Rm.save_add(role);
    }

    @Override
    public RoleVo findById(String id) throws Exception {
        return Rm.findById(id);
    }

    @Override
    public void deleteRoleId(String id) throws Exception {
        Rm.deleteRoleId(id);
    }

    @Override
    public List<Permission> findRoleByIdAndAllPermission(String id) throws Exception {
        return Rm.findRoleByIdAndAllPermission(id);
    }

    @Override
    public void addPermissionToRole(String id, String setId) throws Exception {
        Rm.addPermissionToRole(id,setId);
    }


}
