package com.xdclass.net.springlearningdemo.proxy.cglib;

import java.lang.reflect.Method;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

/**
 * @description: CGLib动态代理
 * @author: Joker.yu 2023-12-19 10:11
 */
public class CglibProxy implements MethodInterceptor {

  // 目标类
  private Object targetObject;

  /**
   * 绑定关系
   *
   * @param targetObject
   * @return 目标类
   */
  public Object newProxyInstance(Object targetObject) {
    this.targetObject = targetObject;
    Enhancer enhancer = new Enhancer();
    // 设置代理类的父类（目标类）
    enhancer.setSuperclass(this.targetObject.getClass());
    // 设置回调函数
    enhancer.setCallback(this);
    // 创建子类（代理对象）
    return enhancer.create();
  }

  /**
   * 拦截
   *
   * @param o 目标类
   * @param method 目标执行的方法
   * @param args 参数
   * @param methodProxy 方法代理
   * @return 目标类
   * @throws Throwable
   */
  @Override
  public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy)
      throws Throwable {
    Object result = null;
    try {
      System.out.println(o.getClass().getTypeName() + "通过CGLIB动态代理调用 " + method.getName() + ", 打印日志 begin");
      result = methodProxy.invokeSuper(o, args);
      System.out.println("通过CGLIB动态代理调用 " + method.getName() + ", 打印日志 begin");
    } catch (Exception e) {
      e.printStackTrace();
    }
    return result;
  }
}
