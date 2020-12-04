package com.detective.stone.awakening.company.common;

import lombok.Data;

@Data
public class RestResult {

  private Integer code;

  private Object data;

  private String message;

  public static RestResult success() {
    return success(null);
  }

  public static RestResult success(Object data) {
    RestResult instance = new RestResult();
    instance.setCode(200);
    instance.setData(data);
    return instance;
  }

  public static RestResult failure(Integer code) {
    return failure(code, null);
  }

  public static RestResult failure(Integer code, String message) {
    RestResult instance = new RestResult();
    instance.setCode(code);
    instance.setMessage(message);
    return instance;
  }
}
