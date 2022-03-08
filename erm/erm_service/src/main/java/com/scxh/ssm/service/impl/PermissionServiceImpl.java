package com.scxh.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.scxh.ssm.dao.PermissionMapper;

import com.scxh.ssm.domain.Permission;
import com.scxh.ssm.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionMapper pm;

    @Override
    public List<Permission> findAll(Integer pageNum, Integer pageSize) throws Exception {
        PageHelper.startPage(pageNum,pageSize);
        List<Permission> list = pm.findAll();
        return  list;
    }

    @Override
    public Permission findById(String id) throws Exception {
        return pm.findById(id);
    }

    @Override
    public void save_add(Permission permission) throws Exception {
        pm.save_add(permission);
    }

    @Override
    public void deletePermissionId(String id) throws Exception {
        pm.deletePermissionId(id);
    }

}
