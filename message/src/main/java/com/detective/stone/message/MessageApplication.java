package com.detective.stone.message;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MessageApplication {

  public static void main(String[] args) {
    SpringApplication.run(MessageApplication.class, args);
    System.out.println("message启动成功");
  }

}
