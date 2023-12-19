package com.xdclass.net.springlearningdemo.proxy;

/**
 * @description: 模拟委托类
 * @author: Joker.yu 2023-12-19 09:33
 */
public interface PayService {

  /**
   * 回调接口
   *
   * @param outTradeNo 订单号
   * @return 返回订单号
   */
  String callback(String outTradeNo);

  /**
   * 保存订单
   *
   * @param userId 用户
   * @param productId 产品id
   * @return 结构
   */
  int save(int userId, int productId);
}
