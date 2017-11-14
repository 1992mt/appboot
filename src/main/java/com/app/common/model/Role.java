package com.app.common.model;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "t_role")
public class Role implements Serializable {
    /**
     * 用户角色id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户角色名称
     */
    private String rolename;

    private static final long serialVersionUID = 1L;

    /**
     * 获取用户角色id
     *
     * @return id - 用户角色id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置用户角色id
     *
     * @param id 用户角色id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取用户角色名称
     *
     * @return rolename - 用户角色名称
     */
    public String getRolename() {
        return rolename;
    }

    /**
     * 设置用户角色名称
     *
     * @param rolename 用户角色名称
     */
    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public enum JavaFieldEnum {
        id,rolename,;
    }

    public enum DbFieldEnum {
        id,rolename,;
    }
}