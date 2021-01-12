package com.detective.stone.awakening.company;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestMain {

  public static void main(String[] args) {
    System.out.println(test());
  }

  public static int test() {
    int x;
    try {
      x = 1;
      x = x / 0;
    } catch (Exception e) {
      x = 2;
      return x;
    } finally {
      x = 3;
      System.out.println("finally-----" + x);
    }
    return x;
  }
}
