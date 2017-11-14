package com.app.web;
//package com.app.api;
//
//import java.util.List;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.validation.Valid;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.app.common.mapper.WxUserMapper;
//import com.app.common.model.WxUser;
//import com.app.common.shiro.util.AuthUtil;
//
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.ApiParam;
//import io.swagger.annotations.ApiResponse;
//import tk.mybatis.mapper.entity.Example;
//
//@RestController
//@RequestMapping(value = "/api",produces = MediaType.APPLICATION_JSON_VALUE)
//@Api(value="用户api接口",produces="MediaType.APPLICATION_JSON_VALUE")
//public class UserController {
//
//	private final Logger log = LoggerFactory.getLogger(UserController.class);
//
//	@Autowired
//	private WxUserMapper wxUserMapper;
//	
//	@Autowired
//	private AuthUtil authUtil;
//
//	/**
//	 * GET /users -> get all the users
//	 */
//	@RequestMapping(value = "/users", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<List<WxUser>> getAll() {
//		log.debug("REST request to get all Users");
//		return new ResponseEntity<>(wxUserMapper.selectAll(), HttpStatus.OK);
//	}
//
//	/**
//	 * GET /users/:userCode -> get the "userCode" user
//	 */
//	@ApiOperation(value="查询用户",notes="根据用户编码查询一个用户，正常返回200")
//	@RequestMapping(value = "/users/{userCode}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<?> getUser(@PathVariable @ApiParam(value="用户名称",example="admin",required=true) String userCode) {
//		log.debug("REST request to get User : {}", userCode);
//		WxUser user = new WxUser();
//		user.setUserCode(userCode);
//		WxUser user1 = wxUserMapper.selectOne(user);
//		if (user1 == null) {
//			return new ResponseEntity<>("not found user", HttpStatus.NOT_FOUND);
//		}
//	
//		log.info("当前用户：{}",authUtil.getUserCode());
//		log.info("当前用户拥有角色个数：{}",authUtil.getRoles().size());
//		return new ResponseEntity<>(user1, HttpStatus.OK);
//	}
//
//	/**
//	 * POST /users -> create a new user
//	 */
//	@RequestMapping(value = "/users", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
//	@ApiResponse(message="201", code = 201)
//	public ResponseEntity<?> create(@Valid @RequestBody WxUser userDto,
//			HttpServletRequest request) { 
//		WxUser user = new WxUser();
//		user.setUserCode(userDto.getUserCode());
//		WxUser user1 = wxUserMapper.selectOne(user);
//		if (user1 != null) {
//			return ResponseEntity.badRequest()
//					.contentType(MediaType.TEXT_PLAIN)
//					.body("username already in use");
//		}
//		wxUserMapper.insert(userDto);
//		return new ResponseEntity<>(HttpStatus.CREATED);
//	}
//
//	/**
//	 * DELETE /users/delete -> ch
//	 */
//	@RequestMapping(value = "/users/{userCode}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<WxUser> delete(@PathVariable String userCode) {
//		WxUser user = new WxUser();
//		user.setUserCode(userCode);
//		wxUserMapper.delete(user);
//		return new ResponseEntity<WxUser>(user,HttpStatus.OK);
//	}
//	
//	/**
//	 * POST /users/change_password -> changes the current user's password
//	 */
//	@RequestMapping(value = "/users", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<?> changePassword(WxUser userDto) {
//		String password = userDto.getPwd();
//		if (password.isEmpty() || password.length() < 5
//				|| password.length() > 50) {
//			return new ResponseEntity<>("invalid password",HttpStatus.BAD_REQUEST);
//		}
//		Example e= new Example(WxUser.class);
//		e.createCriteria().andEqualTo("userCode", userDto.getUserCode());
//		WxUser user = new WxUser();
//		user.setPwd(password);
//		wxUserMapper.updateByExampleSelective(user, e);
//		return new ResponseEntity<WxUser>(user,HttpStatus.OK);
//	}
//
//}
