package com.scxh.ssm.service;

import com.scxh.ssm.domain.Permission;
import com.scxh.ssm.domain.Role;
import com.scxh.ssm.domain.RoleVo;

import java.util.List;

public interface RoleService {
    List<Role> findAll(Integer pageNum, Integer pageSize) throws  Exception;

    void save_add(Role role) throws  Exception;

    RoleVo findById(String id) throws  Exception;

    void deleteRoleId(String id ) throws  Exception;


    List<Permission> findRoleByIdAndAllPermission(String id) throws  Exception;

    void addPermissionToRole(String id, String setId) throws  Exception;
}
