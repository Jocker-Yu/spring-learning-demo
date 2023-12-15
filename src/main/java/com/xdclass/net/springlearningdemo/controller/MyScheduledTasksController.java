package com.xdclass.net.springlearningdemo.controller;

import com.xdclass.net.springlearningdemo.scheduling.MyTestScheduledTasks;
import com.xdclass.net.springlearningdemo.utils.ApiResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: Joker.yu 2023-12-13 10:23
 */
@RestController
@RequestMapping("api/v1/pri/task")
public class MyScheduledTasksController {

  @Autowired private MyTestScheduledTasks myTestScheduledTasks;

  @GetMapping("/hi")
  public ApiResult<Map<String, Object>> testAsyncReturn()
      throws ExecutionException, InterruptedException {
    long start = System.currentTimeMillis();
    Map<String, Object> map = new HashMap<>();
    List<Future<String>> futures = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      Future<String> future = myTestScheduledTasks.doReturn(i);
      futures.add(future);
    }
    List<String> response = new ArrayList<>();
    for (Future<String> future : futures) {
      String string = future.get();
      response.add(string);
    }
    map.put("data", response);
    map.put("消耗时间", String.format("任务执行成功,耗时{%s}毫秒", System.currentTimeMillis() - start));
    return ApiResult.success(map);
  }
}
