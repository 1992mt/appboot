package com.app.common.shiro.realm;

import java.util.List;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.app.common.model.Role;
import com.app.common.model.User;
import com.app.service.PermissionService;
import com.app.service.RoleService;
import com.app.service.UserService;

/**
 * realm:域,完成验证和授权
 * 
 * @author mt
 *
 */
public class MyAuthRealm extends AuthorizingRealm {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private PermissionService permissionService;
	
	/**
	 * 登录，认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken utoken = (UsernamePasswordToken) token;// 获取用户输入的token
		log.info("验证当前Subject时获取到token为：{}" , utoken); 
		String username = utoken.getUsername();
		User user = userService.findUserByUserName(username);//TODO 根据用户名获取数据库用户信息
		 //将此用户存放到登录认证info中，无需自己做密码对比，Shiro会为我们进行密码对比校验
		return new SimpleAuthenticationInfo(user, user.getPassword(), this.getClass().getName());// 放入shiro.调用CredentialsMatcher检验密码
	}

	/**
	 * 授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		log.info("##################执行Shiro权限认证##################");
        //获取当前登录输入的用户名，等价于(String) principalCollection.fromRealm(getName()).iterator().next();
        String loginName = (String)super.getAvailablePrincipal(principals); 
        //到数据库查是否有此对象
        User user=userService.findUserByUserName(loginName);// 实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
        if(user!=null){
            //权限信息对象info,用来存放查出的用户的所有的角色（role）及权限（permission）
            SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
            //用户的角色集合
            List<String> roles = roleService.listRolesName(user.getUsername());
            info.setRoles((Set<String>) roles);
            //用户的角色对应的所有权限，如果只使用角色定义访问权限，下面的四行可以不要
            List<Role> roleList=roleService.listRoles(user.getUsername());
            for (Role role : roleList) {
            	List<String> listPermissionByRole = permissionService.listPermissionByRole(role.getId());
                info.addStringPermissions(listPermissionByRole);
            }
            // 或者按下面这样添加
            //添加一个角色,不是配置意义上的添加,而是证明该用户拥有admin角色    
//            simpleAuthorInfo.addRole("admin");  
            //添加权限  
//            simpleAuthorInfo.addStringPermission("admin:manage");  
//            logger.info("已为用户[mike]赋予了[admin]角色和[admin:manage]权限");
            return info;
        }
        // 返回null的话，就会导致任何用户访问被拦截的请求时，都会自动跳转到unauthorizedUrl指定的地址
        return null;
	}

}
