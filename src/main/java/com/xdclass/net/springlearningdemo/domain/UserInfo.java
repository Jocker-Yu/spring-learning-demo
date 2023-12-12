package com.xdclass.net.springlearningdemo.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import lombok.Data;

/**
 * @description: 用户信息
 * @author: Joker.yu 2023-12-11 13:38
 **/
@Data
public class UserInfo {

  /**
   * 标识
   */
  private Integer id;

  /**
   * 账号
   */
  private String account;

  /**
   * 密码
   */
  private String password;

  /**
   * 头像rul
   */
  private String headImg;

  /**
   * 电话号码
   */
  private String phone;

  /**
   * 创建时间
   */
  private Date createTime;
}
