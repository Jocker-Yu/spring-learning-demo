package com.xdclass.net.springlearningdemo.mybatis.entity;

import java.util.Date;
import lombok.Data;

/**
 * @description: reply
 * @author: Joker.yu 2023-12-15 09:25
 */
@Data
public class Reply {

  private Integer id;

  private Integer topicId;

  private Integer floor;

  private String content;

  private Integer userId;

  private String username;

  private String userImg;

  private Date createTime;

  private Date updateTime;

  private Integer delete;
}
