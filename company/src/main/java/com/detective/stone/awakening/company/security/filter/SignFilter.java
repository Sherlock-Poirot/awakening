package com.detective.stone.awakening.company.security.filter;

import com.detective.stone.awakening.company.common.RestResult;
import com.detective.stone.awakening.company.util.AjaxUtils;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;

/**
 * 用户登录shiro过滤器（支付类不可使用这类过滤器管理权限） 控制用户的认证通过认证和rememberMe可以通过
 */
@Slf4j
public class SignFilter extends AccessControlFilter {

  public static final String MARK = "sign";

  @Override
  protected boolean isAccessAllowed(ServletRequest req, ServletResponse resp, Object mappedValue) {
    Subject subject = getSubject(req, resp);
    // 放行“已认证”、放行“rememberMe”
    return subject.isAuthenticated() || subject.isRemembered();
  }

  // 如果isAccessAllowed()返回false，则调用这个方法
  @Override
  protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
    log.info("请求被SignFilter过滤，返回“未登录或登录超时”");
    AjaxUtils.outputJson(response, RestResult.failure(4001));
    return false;
  }
}
