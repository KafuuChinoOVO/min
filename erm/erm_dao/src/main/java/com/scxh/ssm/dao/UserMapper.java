package com.scxh.ssm.dao;

import com.scxh.ssm.domain.Permission;
import com.scxh.ssm.domain.Role;
import com.scxh.ssm.domain.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    List<UserInfo> findAll() throws  Exception ;

    void save_add(UserInfo userInfo) throws Exception;

    UserInfo findById(String id) throws  Exception;


    List<Role> findUserByIdAndAllRole(String id) throws Exception;

     public void addRoleToUser(@Param("id") String id, @Param("userId") String userId);

    List<Role> findRoleByUserId(String id) throws Exception;

    List<Permission> findPermissionByRoleId(String id) throws  Exception;

    UserInfo findByUsername(String username) ;


    //根据用户名获取该对象
    
}
