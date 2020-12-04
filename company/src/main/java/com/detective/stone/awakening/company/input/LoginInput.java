package com.detective.stone.awakening.company.input;

import lombok.Data;

@Data
public class LoginInput {

  private String username;

  private String password;

  // 验证码 下一阶段做
  private String captcha;

  private Boolean remember;
}
