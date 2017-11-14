package com.app.common.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "t_experience")
public class Experience implements Serializable {
    /**
     * 心得id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 心得文件路径（与内容只能同时存在一个）
     */
    private String fileurl;

    /**
     * 上传心得时间
     */
    private Date addtime;

    /**
     * 修改心得时间
     */
    private Date updatetime;

    /**
     * 心得内容
     */
    private String content;

    private static final long serialVersionUID = 1L;

    /**
     * 获取心得id
     *
     * @return id - 心得id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置心得id
     *
     * @param id 心得id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取用户id
     *
     * @return user_id - 用户id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置用户id
     *
     * @param userId 用户id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取心得文件路径（与内容只能同时存在一个）
     *
     * @return fileurl - 心得文件路径（与内容只能同时存在一个）
     */
    public String getFileurl() {
        return fileurl;
    }

    /**
     * 设置心得文件路径（与内容只能同时存在一个）
     *
     * @param fileurl 心得文件路径（与内容只能同时存在一个）
     */
    public void setFileurl(String fileurl) {
        this.fileurl = fileurl;
    }

    /**
     * 获取上传心得时间
     *
     * @return addtime - 上传心得时间
     */
    public Date getAddtime() {
        return addtime;
    }

    /**
     * 设置上传心得时间
     *
     * @param addtime 上传心得时间
     */
    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    /**
     * 获取修改心得时间
     *
     * @return updatetime - 修改心得时间
     */
    public Date getUpdatetime() {
        return updatetime;
    }

    /**
     * 设置修改心得时间
     *
     * @param updatetime 修改心得时间
     */
    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    /**
     * 获取心得内容
     *
     * @return content - 心得内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置心得内容
     *
     * @param content 心得内容
     */
    public void setContent(String content) {
        this.content = content;
    }

    public enum JavaFieldEnum {
        id,userId,fileurl,addtime,updatetime,content,;
    }

    public enum DbFieldEnum {
        id,user_id,fileurl,addtime,updatetime,content,;
    }
}