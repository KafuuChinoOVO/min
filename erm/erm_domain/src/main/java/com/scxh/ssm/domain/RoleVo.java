package com.scxh.ssm.domain;

import java.util.List;

public class RoleVo {
    private String roleName;
    private List<Permission> Permissions;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<Permission> getPermissions() {
        return Permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        Permissions = permissions;
    }

    @Override
    public String toString() {
        return "RoleVo{" +
                "roleName='" + roleName + '\'' +
                ", Permissions=" + Permissions +
                '}';
    }
}
