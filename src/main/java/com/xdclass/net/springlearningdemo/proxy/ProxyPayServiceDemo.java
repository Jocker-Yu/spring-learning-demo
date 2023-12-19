package com.xdclass.net.springlearningdemo.proxy;

import com.xdclass.net.springlearningdemo.proxy.cglib.CglibProxy;
import com.xdclass.net.springlearningdemo.proxy.jdk.JdkProxy;
import com.xdclass.net.springlearningdemo.proxy.staticd.StaticProxyPayServiceImpl;

/**
 * @description: 代理实操
 * 讲解静态代理优缺点和实操
 *     <p>什么是静态代理
 *          1.由程序创建或特定工具自动生成源代码，在程序运行前，代理类的.class文件就已经存在
 *          2.通过将目标类与代理类实现同一个接口，让代理类持有真实类对象，然后在代理类方法中调用真实类方法，在调用真实类方法的前后添加我们所需要的功能扩展代码来达到增强的目的
 *          3.A -> B -> C
 *     <p>优点
 *          1.代理使客户端不需要知道实现类是什么，怎么做的，而客户端只需知道代理即可
 *          2.方便增加功能，拓展业务逻辑
 *     <p>缺点
 *          1.代理类中出现大量冗余的代码，非常不利于扩展和维护
 *          2.如果接口增加一个方法，除了所有实现类需要实现这个方法外，所有代理类也需要实现此方法。增加了代码维护的复杂度
 *     <p>什么是动态代理
 *          1.在程序运行时，运用反射机制动态创建而成，无需手动编写代码。
 *          2.JDK动态代理与静态代理一样，目标类需要实现一个代理接口,再通过代理对象调用目标方法
 *          3.CgLib动态代理的原理是对指定的业务类生成一个子类，并覆盖其中的业务方法来实现代理
 * 总结CGlib和JDk动态代理
 *     <p>动态代理与静态代理相比较，最大的好处是接口中声明的所有方法都被转移到调用处理器一个集中的方法中处理，解耦和易维护
 *     <p>两种动态代理的区别：
 *          1.JDK动态代理：要求目标对象实现一个接口，但是有时候目标对象只是一个单独的对象,并没有实现任何的接口,这个时候就可以用CGLib动态代理
 *          2.CGLib动态代理,它是在内存中构建一个子类对象从而实现对目标对象功能的扩展
 *          3.JDK动态代理是自带的，CGlib需要引入第三方包
 *          4.CGLib动态代理基于继承来实现代理，所以无法对final类、private方法和static方法实现代理
 *     <p>Spring AOP中的代理使用的默认策略：
 *          1.如果目标对象实现了接口，则默认采用JDK动态代理
 *          2.如果目标对象没有实现接口，则采用CgLib进行动态代理
 *          3.如果目标对象实现了接扣，程序里面依旧可以指定使用CGlib动态代理
 * @author: Joker.yu 2023-12-19 09:38
 */
public class ProxyPayServiceDemo {

  /** 实例 */
  public static final PayService FINAL_PAY_SERVICE = new PayServiceImpl();

  public static void main(String[] args) {
    /*mock 静态代理类执行过程*/
    System.out.println("静态代理类执行过程 ↓");
    StaticProxyPayServiceImpl staticProxyPayService =
        new StaticProxyPayServiceImpl(FINAL_PAY_SERVICE);
    String callback = staticProxyPayService.callback("order-test-111");
    System.out.println("获取到的订单号" + callback + "\n");

    System.out.println("=================================================================\n");

    /*jdk 动态代理*/
    System.out.println("jdk 动态代理 ↓");
    JdkProxy jdkProxy = new JdkProxy();
    PayService payService = (PayService) jdkProxy.newProxyInstance(FINAL_PAY_SERVICE);
    payService.callback("order-test-111");

    System.out.println("=================================================================\n");

    /*CGLib 动态代理*/
    System.out.println("CGLib 动态代理 ↓");
    CglibProxy cglibProxy = new CglibProxy();
    PayService cglibProxyService = (PayService) cglibProxy.newProxyInstance(FINAL_PAY_SERVICE);
    cglibProxyService.callback("order-test-111");
  }
}
