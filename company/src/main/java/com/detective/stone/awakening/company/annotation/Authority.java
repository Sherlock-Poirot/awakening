package com.detective.stone.awakening.company.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
public @interface Authority {

  String display();

  int menuId();

  boolean mustHave() default false;
}
