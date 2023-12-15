package com.xdclass.net.springlearningdemo.mybatis.mapper;

import com.xdclass.net.springlearningdemo.mybatis.entity.Topic;

/**
 * @description: TopicMapper
 * @author: Joker.yu 2023-12-15 09:49
 **/
public interface TopicMapper {

  Topic query(Integer id);
}
