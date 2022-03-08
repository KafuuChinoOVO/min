package com.scxh.ssm.dao;

import com.scxh.ssm.domain.Permission;

import java.util.List;

public interface PermissionMapper {
     public List<Permission> findAll() throws Exception;

     Permission findById(String id) throws Exception;

    void save_add(Permission permission) throws  Exception;

    void deletePermissionId(String id) throws Exception;
}
