package com.xdclass.net.springlearningdemo.mybatis.entity;

import java.util.Date;
import lombok.Data;

/**
 * @description:
 * @author: Joker.yu 2023-12-15 09:30
 **/
@Data
public class Topic {

  private Integer id;

  private Integer cId;

  private String title;

  private String content;

  private Date createTime;

  private Reply reply;

}
