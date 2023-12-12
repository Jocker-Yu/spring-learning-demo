package com.xdclass.net.springlearningdemo.utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import lombok.extern.slf4j.Slf4j;

/**
 * 工具类
 */
@Slf4j
public class CommonUtils {

  /**
   * MD5加密工具类
   *
   * @param data
   * @return
   */
  public static String MD5(String data) {
    try {
      java.security.MessageDigest md = MessageDigest.getInstance("MD5");
      byte[] array = md.digest(data.getBytes(StandardCharsets.UTF_8));
      StringBuilder sb = new StringBuilder();
      for (byte item : array) {
        sb.append(Integer.toHexString((item & 0xFF) | 0x100), 1, 3);
      }
      return sb.toString().toUpperCase();
    } catch (Exception e) {
      log.error("【CommonUtils.MD5】生成MD5加密失败：{}", e.getMessage());
    }
    return null;
  }

}
