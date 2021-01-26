package com.detective.stone.awakening.company.controller;

import com.detective.stone.awakening.company.common.RestResult;
import com.detective.stone.awakening.company.model.User;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

  @Autowired
  private RabbitTemplate rabbitTemplate;

  @GetMapping("/hello")
  public RestResult hello() {
    return RestResult.success("hello world!");
  }

  @GetMapping("/sendMessage")
  public RestResult sendMessage() {
    rabbitTemplate.convertAndSend("mercantilism", "", "这是测试消息");
    return RestResult.success();
  }
}
