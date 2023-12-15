package com.xdclass.net.springlearningdemo.mybatis.mapper;

import com.xdclass.net.springlearningdemo.mybatis.entity.Category;

/**
 * @description: CategoryMapper
 * @author: Joker.yu 2023-12-15 09:18
 **/
public interface CategoryMapper {

  Category queryCategory(Integer id);
}
