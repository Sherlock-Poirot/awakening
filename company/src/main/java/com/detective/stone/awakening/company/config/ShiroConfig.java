package com.detective.stone.awakening.company.config;

import com.detective.stone.awakening.company.controller.SignController;
import com.detective.stone.awakening.company.model.Permission;
import com.detective.stone.awakening.company.security.SecurityCredentialsMatcher;
import com.detective.stone.awakening.company.security.SecurityRealm;
import com.detective.stone.awakening.company.security.filter.PermissionFilter;
import com.detective.stone.awakening.company.security.filter.SignFilter;
import com.detective.stone.awakening.company.service.PermissionService;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.Filter;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShiroConfig {

  @Autowired
  private PermissionService permissionService;

  @Bean
  public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
    ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
    // 设置shiro的核心管理组件 也就是下面的bean  securityManager()
    shiroFilterFactoryBean.setSecurityManager(securityManager);
    // 设置过滤器链 这是尤为重要的一个环节任何的接口路由或者静态资源在这里被过滤大多数采用默认过滤器不过你也可以自定义过滤器实现逻辑
    shiroFilterFactoryBean.setFilters(createFilters());
    // 默认的 auth，authc，anon，user auth是授权 anon是任何都可以通过，authc是认证后可以访问，user则是设置rememberMe之后也可通过
//    Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
//    filterChainDefinitionMap.put("/**", "anon");
    shiroFilterFactoryBean.setFilterChainDefinitionMap(createFilterChainDefinitions());
    return shiroFilterFactoryBean;
  }

  private Map<String, Filter> createFilters() {
    Map<String, Filter> map = new HashMap<>(2);
    map.put(SignFilter.MARK, new SignFilter());
    map.put(PermissionFilter.MARK, new PermissionFilter());
    return map;
  }

  private Map<String, String> createFilterChainDefinitions() {
    Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
    // 登录接口无需权限
    filterChainDefinitionMap.put(SignController.LOGIN_PATCH, "anon");
    // 登出接口需要认证后
    filterChainDefinitionMap.put(SignController.LOGOUT_PATCH, SignFilter.MARK);
    // 组装权限
    List<Permission> permissions = permissionService.list();
    for (Permission permission : permissions) {
      filterChainDefinitionMap
          .put(permission.getMapping(), SignFilter.MARK + "," + PermissionFilter.MARK + "[" + permission.getName() + "]");
    }
    filterChainDefinitionMap.put("/test/**", "anon");
    return filterChainDefinitionMap;
  }

  @Bean
  public DefaultWebSecurityManager securityManager() {
    DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
    // 设置realm 还可以设置多realm模式 自定义实现多realm的认证策略
    securityManager.setRealm(myRealm());
    // 设置多realms 并制定全身份认证通过策略 AllSuccessfulStrategy  AtLeastOne...  First... 默认三种策略
//    securityManager.setRealms();
//    ModularRealmAuthenticator authenticator = new ModularRealmAuthenticator();
//    authenticator.setAuthenticationStrategy(new AllSuccessfulStrategy());
//    securityManager.setAuthenticator(authenticator);
    return securityManager;
  }

  @Bean
  public SecurityRealm myRealm() {
    SecurityRealm myRealm = new SecurityRealm();
    // 设置自定义的密码校验器
    myRealm.setCredentialsMatcher(new SecurityCredentialsMatcher());
    return myRealm;
  }
}
