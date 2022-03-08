package com.scxh.ssm.service;

import com.scxh.ssm.domain.Permission;
import com.scxh.ssm.domain.Role;
import com.scxh.ssm.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    List<UserInfo> findAll(Integer pageNum, Integer pageSize) throws  Exception;

    void save_add(UserInfo userInfo) throws  Exception;

    UserInfo findById(String id) throws Exception;


    List<Role> findUserByIdAndAllRole(String id) throws  Exception;

    void addRoleToUser(String id, String userId) throws Exception;

    List<Role> findRoleByUserId(String id) throws Exception;


    List<Permission> findPermissionByRoleId(String id) throws  Exception;
}
