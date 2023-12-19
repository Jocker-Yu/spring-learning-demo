package com.xdclass.net.springlearningdemo.proxy;

/**
 * @description:
 * @author: Joker.yu 2023-12-19 09:37
 */
public class PayServiceImpl implements PayService {

  public String callback(String outTradeNo) {
    System.out.println("PayServiceImpl callback 方法被执行。。。。");
    return outTradeNo;
  }

  public int save(int userId, int productId) {
    System.out.println("PayServiceImpl save 方法被执行。。。。");
    return productId;
  }
}
