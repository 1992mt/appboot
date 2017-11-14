package com.app.common.model;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "t_permission")
public class Permission implements Serializable {
    /**
     * 用户权限id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户权限（增，删，改，查）
     */
    private String permissionname;

    /**
     * 用户角色id
     */
    @Column(name = "role_id")
    private Integer roleId;

    private static final long serialVersionUID = 1L;

    /**
     * 获取用户权限id
     *
     * @return id - 用户权限id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置用户权限id
     *
     * @param id 用户权限id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取用户权限（增，删，改，查）
     *
     * @return permissionname - 用户权限（增，删，改，查）
     */
    public String getPermissionname() {
        return permissionname;
    }

    /**
     * 设置用户权限（增，删，改，查）
     *
     * @param permissionname 用户权限（增，删，改，查）
     */
    public void setPermissionname(String permissionname) {
        this.permissionname = permissionname;
    }

    /**
     * 获取用户角色id
     *
     * @return role_id - 用户角色id
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * 设置用户角色id
     *
     * @param roleId 用户角色id
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public enum JavaFieldEnum {
        id,permissionname,roleId,;
    }

    public enum DbFieldEnum {
        id,permissionname,role_id,;
    }
}