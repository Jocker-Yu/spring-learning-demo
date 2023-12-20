package com.xdclass.net.springlearningdemo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("my/11/1、2/")
public class MyDemoController {

  @GetMapping("map")
  public Map<String, Object> testMap() {
    Map<String, Object> map = new HashMap<>();
    map.put("A", "BSDADSA");
    ArrayList<String> list = new ArrayList<>();
    list.add("11231");
    list.add("3");
    list.add("2");
    map.put("B", list);
    return map;
  }
}
