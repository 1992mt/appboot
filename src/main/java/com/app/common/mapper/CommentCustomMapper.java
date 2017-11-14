package com.app.common.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.app.common.model.Comment;
import com.app.common.model.response.CommentResponse;

import tk.mybatis.mapper.common.Mapper;

/**
 * 多表关联查询
 * @author mt
 *
 */
public interface CommentCustomMapper extends Mapper<Comment> {
	List<CommentResponse> listComment(@Param("id")String id);
}