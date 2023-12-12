package com.xdclass.net.springlearningdemo.service.impl;

import com.xdclass.net.springlearningdemo.dao.map.UserMapDao;
import com.xdclass.net.springlearningdemo.domain.UserInfo;
import com.xdclass.net.springlearningdemo.exception.XDException;
import com.xdclass.net.springlearningdemo.service.UserService;
import com.xdclass.net.springlearningdemo.utils.ApiResult;
import com.xdclass.net.springlearningdemo.utils.CommonUtils;
import java.util.Date;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description: 用户服务
 * @author: Joker.yu 2023-12-11 11:42
 **/
@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserMapDao userMapDao;

  /**
   * 放在CDN上的随机头像
   */
  private static final String[] headImg = {
      "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/12.jpeg",
      "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/11.jpeg",
      "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/13.jpeg",
      "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/14.jpeg",
      "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/15.jpeg"
  };


  @Override
  public void register(Map<String, String> userInfo) {
    userMapDao.register(parseToUser(userInfo));
  }

  @Override
  public UserInfo query(Integer id) {
    UserInfo userInfo = userMapDao.query(id);
    if (Objects.isNull(userInfo)) {
      String errorMessage = String.format("未查询到id为%s的用户信息!", id);
      throw new XDException(ApiResult.ERROR_CODE, errorMessage);
    }
    return userInfo;
  }

  /**
   * 解析 user 对象
   *
   * @param userInfo
   * @return
   */
  private UserInfo parseToUser(Map<String, String> userInfo) {
    String password = userInfo.get("password");
    String account = userInfo.get("account");
    if (StringUtils.isBlank(password) || StringUtils.isBlank(account)) {
      throw new XDException(ApiResult.ERROR_CODE, "账号或密码不能为空");
    }
    UserInfo user = new UserInfo();
    user.setId(Math.abs(new Random().nextInt()));
    user.setAccount(account);
    user.setHeadImg(getRandomImg());
    user.setCreateTime(new Date());
    user.setPhone(userInfo.get("phone"));
    //MD5加密
    user.setPassword(CommonUtils.MD5(password));
    return user;
  }

  /**
   * 获取随机头像
   *
   * @return 结果
   */
  private String getRandomImg() {
    Random random = new Random();
    int index = random.nextInt(headImg.length);
    return headImg[index];
  }
}
