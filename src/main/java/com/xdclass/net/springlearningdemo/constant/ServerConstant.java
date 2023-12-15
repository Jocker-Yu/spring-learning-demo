package com.xdclass.net.springlearningdemo.constant;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @description: 测试properties
 * @author: Joker.yu 2023-12-12 11:14
 */
@Data
@Component
@ConfigurationProperties(prefix = "constant")
@PropertySource(value = "classpath:application-server-constant.properties", encoding = "UTF-8")
public class ServerConstant {

  /** 名称 */
  private String name;
}
