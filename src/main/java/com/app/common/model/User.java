package com.app.common.model;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "t_user")
public class User implements Serializable {
    /**
     * 用户id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 手机序列号（以便登录校验）
     */
    private String serialnumber;

    /**
     * 微信openId
     */
    @Column(name = "openId")
    private String openid;

    private static final long serialVersionUID = 1L;

    /**
     * 获取用户id
     *
     * @return id - 用户id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置用户id
     *
     * @param id 用户id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取用户名
     *
     * @return username - 用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置用户名
     *
     * @param username 用户名
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取手机序列号（以便登录校验）
     *
     * @return serialnumber - 手机序列号（以便登录校验）
     */
    public String getSerialnumber() {
        return serialnumber;
    }

    /**
     * 设置手机序列号（以便登录校验）
     *
     * @param serialnumber 手机序列号（以便登录校验）
     */
    public void setSerialnumber(String serialnumber) {
        this.serialnumber = serialnumber;
    }

    /**
     * 获取微信openId
     *
     * @return openId - 微信openId
     */
    public String getOpenid() {
        return openid;
    }

    /**
     * 设置微信openId
     *
     * @param openid 微信openId
     */
    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public enum JavaFieldEnum {
        id,username,password,serialnumber,openid,;
    }

    public enum DbFieldEnum {
        id,username,password,serialnumber,openId,;
    }
}