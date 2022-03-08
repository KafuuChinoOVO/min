package com.scxh.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.scxh.ssm.dao.UserMapper;
import com.scxh.ssm.domain.Permission;
import com.scxh.ssm.domain.Role;
import com.scxh.ssm.domain.UserInfo;
import com.scxh.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper um;

    @Override
    public List<UserInfo> findAll(Integer pageNum, Integer pageSize) throws Exception {
        PageHelper.startPage(pageNum,pageSize);
        List<UserInfo> list = um.findAll();
        return list;
    }

    @Override
    public void save_add(UserInfo userInfo) throws Exception {
        um.save_add(userInfo);
    }

    @Override
    public UserInfo findById(String id) throws Exception {
        return um.findById(id);
    }

    @Override
    public List<Role> findUserByIdAndAllRole(String id) throws Exception {
        return um.findUserByIdAndAllRole(id);
    }

    @Override
    public void addRoleToUser(String id, String userId) throws Exception {
        um.addRoleToUser(id,userId);
    }

    @Override
    public List<Role> findRoleByUserId(String id) throws Exception {
        return um.findRoleByUserId(id);
    }

    @Override
    public List<Permission> findPermissionByRoleId(String id) throws Exception {
        return um.findPermissionByRoleId(id);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //接收传进来的用户名，去数据库获取该对象（UserInfo）
        //自己写后台
        UserInfo userInfo = um.findByUsername(username);
        //将自己的对象封装成spring security自己的用户User(UserDetails接口的实现类)，然后返回这个User
        /**
         * public User(String username, String password, boolean enabled,
         * 			boolean accountNonExpired, boolean credentialsNonExpired,
         * 			boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities)
         */
        User user = new User(username,userInfo.getPassword(),
                userInfo.getStatus() == 1 ? true:false,true,true,true,
                getAuthorites(userInfo.getRoles())
        );
        return user;
    }

    //将userInfo.getRoles()中的角色集合封装成spring security自己的权限认证
    //SimpleGrantedAuthority是GrantedAuthority的一个实现类
    private List<SimpleGrantedAuthority> getAuthorites(List<Role> roles) {
        List<SimpleGrantedAuthority> list = new ArrayList<>();
        for (Role role : roles) {
            list.add(new SimpleGrantedAuthority(("ROLE_"+role.getRoleName())));//数据库中是ADMIN，拼接成了ROLE_ADMIN
        }
        return list;
    }
}
