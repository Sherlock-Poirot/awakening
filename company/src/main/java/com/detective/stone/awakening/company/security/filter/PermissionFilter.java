package com.detective.stone.awakening.company.security.filter;

import com.detective.stone.awakening.company.common.RestResult;
import com.detective.stone.awakening.company.util.AjaxUtils;
import java.io.IOException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.web.filter.authz.PermissionsAuthorizationFilter;

@Slf4j
public class PermissionFilter extends PermissionsAuthorizationFilter {

  public static final String MARK = "perm";

  // 如果isAccessAllowed()返回false，则调用这个方法
  @Override
  protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws IOException {
    log.info("请求被PermissionFilter过滤，返回“权限不足”");
    AjaxUtils.outputJson(response, RestResult.failure(403));
    return false;
  }
}
