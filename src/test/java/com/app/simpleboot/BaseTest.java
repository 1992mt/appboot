package com.app.simpleboot;
//
//import java.util.List;
//
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.cache.CacheManager;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import com.app.Application;
//import com.app.common.mapper.WxCounterMapper;
//import com.app.common.mapper.WxUserMapper;
//import com.app.common.model.WxCounter;
//import com.app.common.model.WxUser;
//import com.app.web.UserService;
//
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest(classes = Application.class)  
public class BaseTest {
//
//	@Autowired
//	private WxCounterMapper wxCounterMapper;
//	
//	@Autowired
//	private WxUserMapper wxUserMapper;
//	
//	@Autowired
//	private UserService userService;
//	
//	@Autowired
//	private CacheManager cacheManager;
//	
//	@Test
//	public void testWxCounter(){
//		List<WxCounter> selectAll = wxCounterMapper.selectAll();
//		Assert.assertNotEquals(selectAll.size(), 0);
//	}
//	
//	@Test
//	public void testGetUser() {
//		WxUser user = new WxUser();
//		user.setUserCode("admin");
//		WxUser user1 = wxUserMapper.selectOne(user);
//		System.out.println(user1.getUserName());
//	}
//	
//
//	@Test
//	public void testCache() {
////		WxUser userByUserCode = userService.getUserByUserCode("admin");
////		WxUser userByUserCode1 = userService.getUserByUserCode("admin");
//		cacheManager.getCache("wxUser");
//		System.out.println(cacheManager.getClass());
//	}
//	
	public static void main(String[] args) {
		String fileName = "mt20171112082314新建文本文档.txt";
		String substring = fileName.substring(0, fileName.lastIndexOf("."));
		System.out.println("substring:"+substring);
	}
}
