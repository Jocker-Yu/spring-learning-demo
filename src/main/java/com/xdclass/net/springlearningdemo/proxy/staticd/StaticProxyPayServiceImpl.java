package com.xdclass.net.springlearningdemo.proxy.staticd;

import com.xdclass.net.springlearningdemo.proxy.PayService;

/**
 * @description:
 * @author: Joker.yu 2023-12-19 09:35
 */
public class StaticProxyPayServiceImpl implements PayService {

  private PayService payService;

  public StaticProxyPayServiceImpl(PayService payService) {
    this.payService = payService;
  }

  public String callback(String outTradeNo) {
    System.out.println("StaticProxyPayServiceImpl callback begin");
    String result = payService.callback(outTradeNo);
    System.out.println("StaticProxyPayServiceImpl callback end");
    return result;
  }

  public int save(int userId, int productId) {
    System.out.println("StaticProxyPayServiceImpl save begin");
    int id = payService.save(userId, productId);
    System.out.println("StaticProxyPayServiceImpl save end");
    return id;
  }
}
