package com.xdclass.net.springlearningdemo.controller;

import com.xdclass.net.springlearningdemo.domain.UserInfo;
import com.xdclass.net.springlearningdemo.service.UserService;
import com.xdclass.net.springlearningdemo.utils.ApiResult;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户管理控制器
 *
 * @description: 用户管理用户登录、注册、个人信息相关
 * @author: Joker.yu 2023-12-11 11:10
 */
@RestController
@RequestMapping("api/v1/pri/user")
public class UserController {

  @Autowired
  private UserService userService;

  @PostMapping("register")
  public ApiResult<Object> register(@RequestBody Map<String, String> userInfo) {
    userService.register(userInfo);
    return ApiResult.success();
  }

  @GetMapping("{id}")
  public ApiResult<UserInfo> register(@PathVariable("id") Integer id) {
    return ApiResult.success(userService.query(id));
  }
}
