package com.scxh.ssm.service;

import com.scxh.ssm.domain.Permission;
import com.scxh.ssm.domain.Product;

import java.util.List;

public interface PermissionService {
    List<Permission> findAll(Integer pageNum, Integer pageSize) throws  Exception;

    Permission findById(String id) throws Exception;


    void save_add(Permission permission) throws  Exception;

    void deletePermissionId(String id) throws  Exception;
}
