package com.app.web;

import java.util.Date;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.common.model.Comment;
import com.app.common.model.User;
import com.app.common.model.response.CommentResponse;
import com.app.service.CommentService;

/**
 * 评论控制层
 * @author mt
 *
 */
@Controller
@RequestMapping(value = "")
public class CommentController {

	private final Logger log = LoggerFactory.getLogger(CommentController.class);
	
	@Autowired
	private CommentService commentService;
	
	/**
	 * 加载心得评论数据
	 * @param experienceListParam
	 * @return
	 */
	@RequestMapping(value = "listCommentByPage", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ResponseBody
	public List<CommentResponse> listCommentByPage(String id){
		return commentService.listCommentByExpId(id);
	}
	
	/**
	 * 新增评论
	 * @param comment
	 * @return
	 */
	@RequestMapping(value = "addComment", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ResponseBody
	public int addComment(Comment comment){
		Subject currentUser = SecurityUtils.getSubject();  
		 User user = (User) currentUser.getSession().getAttribute("user");
		 comment.setUserId(user.getId());
		comment.setCommenttime(new Date());
		comment.setCommentupdatetime(new Date());
		return commentService.addComment(comment);
	}
	
	/**
	 * 删除评论
	 * @param comment
	 * @return
	 */
	@RequestMapping(value = "deleteComment", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ResponseBody
	public int deleteComment(Comment comment){
		return commentService.deleteComment(comment);
	}
	
	

}
