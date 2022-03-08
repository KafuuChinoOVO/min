package com.scxh.ssm.dao;

import com.scxh.ssm.domain.Permission;
import com.scxh.ssm.domain.Role;
import com.scxh.ssm.domain.RoleVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper {
    List<Role> findAll() throws  Exception;

    void save_add(Role role) throws  Exception;

    RoleVo findById(String id) throws  Exception;

    void deleteRoleId(String id) throws Exception;


    List<Permission> findRoleByIdAndAllPermission(String id) throws  Exception;

     public void addPermissionToRole(@Param("id")String id, @Param("setId")String setId) throws  Exception ;
}
