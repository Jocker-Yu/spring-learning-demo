package com.xdclass.net.springlearningdemo.service;

import com.xdclass.net.springlearningdemo.domain.UserInfo;
import java.util.Map;

/**
 * @description:
 * @author: Joker.yu 2023-12-11 11:37
 **/
public interface UserService {

  /**
   * 注册用户
   * @param userInfo userInfo
   */
  void register(Map<String, String> userInfo);

  /**
   * 查询用户
   * @param id id
   * @return UserInfo
   */
  UserInfo query(Integer id);
}
