package com.app.common.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "t_comment")
public class Comment implements Serializable {
    /**
     * 评论id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 评论的用户id
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 心得id
     */
    @Column(name = "exp_id")
    private Integer expId;

    /**
     * 评论图片路径
     */
    private String commentimg;

    /**
     * 评论时间
     */
    private Date commenttime;

    /**
     * 评论修改时间
     */
    private Date commentupdatetime;

    /**
     * 评论内容
     */
    private String content;

    private static final long serialVersionUID = 1L;

    /**
     * 获取评论id
     *
     * @return id - 评论id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置评论id
     *
     * @param id 评论id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取评论的用户id
     *
     * @return user_id - 评论的用户id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置评论的用户id
     *
     * @param userId 评论的用户id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取心得id
     *
     * @return exp_id - 心得id
     */
    public Integer getExpId() {
        return expId;
    }

    /**
     * 设置心得id
     *
     * @param expId 心得id
     */
    public void setExpId(Integer expId) {
        this.expId = expId;
    }

    /**
     * 获取评论图片路径
     *
     * @return commentimg - 评论图片路径
     */
    public String getCommentimg() {
        return commentimg;
    }

    /**
     * 设置评论图片路径
     *
     * @param commentimg 评论图片路径
     */
    public void setCommentimg(String commentimg) {
        this.commentimg = commentimg;
    }

    /**
     * 获取评论时间
     *
     * @return commenttime - 评论时间
     */
    public Date getCommenttime() {
        return commenttime;
    }

    /**
     * 设置评论时间
     *
     * @param commenttime 评论时间
     */
    public void setCommenttime(Date commenttime) {
        this.commenttime = commenttime;
    }

    /**
     * 获取评论修改时间
     *
     * @return commentupdatetime - 评论修改时间
     */
    public Date getCommentupdatetime() {
        return commentupdatetime;
    }

    /**
     * 设置评论修改时间
     *
     * @param commentupdatetime 评论修改时间
     */
    public void setCommentupdatetime(Date commentupdatetime) {
        this.commentupdatetime = commentupdatetime;
    }

    /**
     * 获取评论内容
     *
     * @return content - 评论内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置评论内容
     *
     * @param content 评论内容
     */
    public void setContent(String content) {
        this.content = content;
    }

    public enum JavaFieldEnum {
        id,userId,expId,commentimg,commenttime,commentupdatetime,content,;
    }

    public enum DbFieldEnum {
        id,user_id,exp_id,commentimg,commenttime,commentupdatetime,content,;
    }
}