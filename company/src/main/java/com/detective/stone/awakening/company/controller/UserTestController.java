package com.detective.stone.awakening.company.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Detective Stone
 * @date 2020/3/19
 */
@RestController
@RequestMapping("/user")
public class UserTestController {

    @GetMapping("/username")
    public String getUsername() {
        return "Detective Stone";
    }
}
