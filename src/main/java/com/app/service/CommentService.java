package com.app.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.common.mapper.CommentCustomMapper;
import com.app.common.mapper.CommentMapper;
import com.app.common.model.Comment;
import com.app.common.model.response.CommentResponse;

/**
 * 评论service
 * @author mt
 *
 */
@Service
public class CommentService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CommentMapper commentMapper;
	
	@Autowired
	private CommentCustomMapper commentCustomMapper;
	
	/**
	 * 查询评论
	 * @param id
	 * @return
	 */
	public List<CommentResponse> listCommentByExpId(String id){
		return commentCustomMapper.listComment(id);
	}
	
	/**
	 * 新增评论
	 * @param comment
	 * @return
	 */
	public int addComment(Comment comment){
		return commentMapper.insertSelective(comment);
	}
	
	/**
	 * 删除评论
	 * @param comment
	 * @return
	 */
	public int deleteComment(Comment comment){
		return commentMapper.deleteByPrimaryKey(comment.getId());
	}
}
