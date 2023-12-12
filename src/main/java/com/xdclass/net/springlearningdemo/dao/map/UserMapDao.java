package com.xdclass.net.springlearningdemo.dao.map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xdclass.net.springlearningdemo.domain.UserInfo;
import com.xdclass.net.springlearningdemo.exception.XDException;
import com.xdclass.net.springlearningdemo.utils.ApiResult;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

/**
 * @description: 用户Map缓存数仓
 * @author: Joker.yu 2023-12-11 13:36
 **/
@Slf4j
@Repository
public class UserMapDao {

  private final static Map<Integer, UserInfo> userInfoMap;

  static {
    userInfoMap = new HashMap<>();
  }

  /**
   * 注册用户
   *
   * @param userInfo
   */
  public void register(UserInfo userInfo) {
    if (Objects.nonNull(userInfo)) {
      List<String> accountList = userInfoMap.values().stream().map(UserInfo::getAccount)
          .collect(Collectors.toList());
      if (accountList.contains(userInfo.getAccount())) {
        throw new XDException(ApiResult.ERROR_CODE, "账号已存在!");
      }
      userInfoMap.put(userInfo.getId(), userInfo);
      try {
        log.info("【UserMapDao.userInfoMap】添加到的用户信息{}",
            new ObjectMapper().writeValueAsString(userInfo));
      } catch (JsonProcessingException e) {
        throw new XDException(ApiResult.ERROR_CODE, e.getMessage());
      }
    }
  }

  /**
   * 查询用户
   *
   * @param id id
   * @return 结果
   */
  public UserInfo query(Integer id) {
    return userInfoMap.get(id);
  }
}
