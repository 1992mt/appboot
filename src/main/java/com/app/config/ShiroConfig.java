package com.app.config;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.Filter;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.mgt.DefaultSessionStorageEvaluator;
import org.apache.shiro.mgt.DefaultSubjectDAO;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.DefaultSessionManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.authc.AnonymousFilter;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.app.common.shiro.filter.MyAuthcFilter;
import com.app.common.shiro.realm.MyAuthRealm;
import com.app.service.UserService;


/**
 * shiro配置
 * @author mt
 *
 */
@Configuration
public class ShiroConfig {
     
     private static final Logger logger = LoggerFactory.getLogger(ShiroConfig.class);
     
    /* @Bean
     public EhCacheManager getEhCacheManager() {  
         EhCacheManager em = new EhCacheManager();  
         em.setCacheManagerConfigFile("classpath:ehcache-shiro.xml");  
         return em;  
     }  */
     
     @Bean
     public MyAuthRealm myAuthRealm(){
          logger.info("ShiroConfig.myAuthRealm()");
          MyAuthRealm realm = new MyAuthRealm();
//          realm.setCacheManager(cacheManager);
          return realm;
     }
     
     /**
      * 安全管理类
      * @param statelessRealm
      * @return
      */
     @Bean
     public DefaultWebSecurityManager defaultWebSecurityManager(MyAuthRealm myAuthRealm){
          logger.info("ShiroConfig.getDefaultWebSecurityManager()");
          DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
          
          manager.setRealm(myAuthRealm);
          
//        <!-- 用户授权/认证信息Cache, 采用EhCache 缓存 --> 
//          manager.setCacheManager(getEhCacheManager());
          //设置了SecurityManager采用使用SecurityUtils的静态方法 获取用户等
          SecurityUtils.setSecurityManager(manager);
          return manager;
     }
     
     /**
      * Shiro生命周期处理
      * @return
      */
     @Bean
     public LifecycleBeanPostProcessor lifecycleBeanPostProcessor(){
          logger.info("ShiroConfig.getLifecycleBeanPostProcessor()");
          return new LifecycleBeanPostProcessor();
     }
     
     
     /**
      * 身份验证过滤器
      * @param manager
      * @param tokenManager
      * @return
      */
     @Bean
     public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager manager){
          logger.info("ShiroConfig.getShiroFilterFactoryBean()");
          ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
          bean.setSecurityManager(manager);
          Map<String,Filter> filters = new HashMap<String,Filter>();
          //无需增加 shiro默认会添加该filter
          //filters.put("anon", anonymousFilter()); 
          
          //无状态授权过滤器 
         //特别注意！不能声明为bean 否则shiro无法管理该filter生命周期，该过滤器会执行其他过滤器拦截过的路径
          MyAuthcFilter myAuthcFilter = myAuthcFilter();
          filters.put("myAuthc", myAuthcFilter);
          bean.setFilters(filters);
          //注意是LinkedHashMap 保证有序
          Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
          
          //1， 相同url规则，后面定义的会覆盖前面定义的(执行的时候只执行最后一个)。
          //2， 两个url规则都可以匹配同一个url，只执行第一个
          filterChainDefinitionMap.put("/css/**", "anon");
          filterChainDefinitionMap.put("/img/**", "anon");
          filterChainDefinitionMap.put("/js/**", "anon");
          filterChainDefinitionMap.put("/fonts/**", "anon");
          filterChainDefinitionMap.put("/html/**", "anon");
          filterChainDefinitionMap.put("/resource/**", "anon");
          filterChainDefinitionMap.put("/login", "anon");
          filterChainDefinitionMap.put("/login/**", "anon");
          filterChainDefinitionMap.put("/favicon.ico", "anon");
          filterChainDefinitionMap.put("/index**", "anon");
          filterChainDefinitionMap.put("/toRegist**", "anon");
          filterChainDefinitionMap.put("/header**", "anon");
          filterChainDefinitionMap.put("/footer**", "anon");
          filterChainDefinitionMap.put("/regist**", "anon");
          filterChainDefinitionMap.put("/logout**", "anon");
          
          filterChainDefinitionMap.put("/**", "myAuthc");//通过myAuthcFilter过滤所有路径
          
          bean.setFilterChainDefinitionMap(filterChainDefinitionMap);
          
          //字符串方式创建过滤链 \n换行 
//        String s = "/resource/**=anon\n/html/**=anon\n/login/**=anon\n/login=anon\n/**=statelessAuthc";
//        bean.setFilterChainDefinitions(s);
          return bean;
     }
     
   /**
    * @Description: 该过滤器无需增加 shiro默认会添加该filter
    * @author: mt
    */
   public AnonymousFilter anonymousFilter(){
        logger.info("ShiroConfig.anonymousFilter()");
        return new AnonymousFilter();
   }
   
   /**
    * @Description:  无状态授权过滤器 注意不能声明为bean 否则shiro无法管理该filter生命周期，<br>
    * 				  该过滤器会执行其他过滤器拦截过的路径
    * @author: mt
    */
   public MyAuthcFilter myAuthcFilter(){
       logger.info("ShiroConfig.statelessAuthcFilter()");
       MyAuthcFilter myAuthcFilter = new MyAuthcFilter();
       return myAuthcFilter;
  }
   
   
     
     
}
