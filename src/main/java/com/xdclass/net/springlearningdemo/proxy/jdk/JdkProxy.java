package com.xdclass.net.springlearningdemo.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @description: jdk 动态代理类 (定义一个java.lang.reflect.InvocationHandler接口的实现类，重写invoke方法)
 * @author: Joker.yu 2023-12-19 09:48
 */
public class JdkProxy implements InvocationHandler {

  private Object targetObject;

  // 获取代理对象
  public Object newProxyInstance(Object targetObject) {
    this.targetObject = targetObject;
    // 绑定关系，也就是和具体的哪个实现类关联
    return Proxy.newProxyInstance(
        targetObject.getClass().getClassLoader(), targetObject.getClass().getInterfaces(), this);
  }

  /**
   * 调用目标类方法
   *
   * @param proxy 被代理的对象
   * @param method 要调用的方法
   * @param args 方法调用时所需要参数
   * @return
   */
  @Override
  public Object invoke(Object proxy, Method method, Object[] args) {
    Object result = null;
    try {
      System.out.println("通过JDK动态代理调用 " + method.getName() + ", 打印日志 begin");
      result = method.invoke(targetObject, args);
      System.out.println("通过JDK动态代理调用 " + method.getName() + ", 打印日志 end");
    } catch (Exception e) {
      e.printStackTrace();
    }
    return result;
  }
}
