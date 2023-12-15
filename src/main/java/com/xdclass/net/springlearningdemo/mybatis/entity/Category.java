package com.xdclass.net.springlearningdemo.mybatis.entity;

import java.util.Date;
import lombok.Data;

/**
 * @description: category
 * @author: Joker.yu 2023-12-15 09:15
 **/
@Data
public class Category {

  private Integer id;

  private String name;

  private String weight;

  private Date createTime;
}
