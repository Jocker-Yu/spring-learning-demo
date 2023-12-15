package com.xdclass.net.springlearningdemo.scheduling;

import com.xdclass.net.springlearningdemo.constant.ServerConstant;
import java.time.LocalDateTime;
import java.util.concurrent.Future;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

/**
 * @description: 测试定时任务
 * @author: Joker.yu 2023-12-12 11:11
 */
@Async
@Component
public class MyTestScheduledTasks {

  @Autowired private ServerConstant serverConstant;

  //  @Scheduled(cron = "0/2 * * * * ?")
  //  @Scheduled(fixedDelay = 4000)
  public void test() throws InterruptedException {
    System.out.println("MyTestScheduledTasks：" + LocalDateTime.now());
    Thread.sleep(5000);
  }

  /**
   * 测试异步返回结果任务
   * @param i
   * @return 结果
   */
  public Future<String> doReturn(int i){
    try {
      // 这个方法需要调用500毫秒
      Thread.sleep(500);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    // 消息汇总
    return new AsyncResult<>(String.format("这个是第{%s}个异步调用的证书", i));
  }
}
