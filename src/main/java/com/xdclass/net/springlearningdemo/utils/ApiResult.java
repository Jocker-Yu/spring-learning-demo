package com.xdclass.net.springlearningdemo.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(Include.NON_NULL)
public class ApiResult<T> {

  /**
   * 状态码
   */
  private Integer code;

  /**
   * 业务数据
   */
  private T data;

  /**
   * 业务数据
   */
  private Object errorData;

  /**
   * 信息表示
   */
  private String message;

  /**
   * 表示成功编码
   */
  private final static Integer SUCCESS_CODE = 0;

  /**
   * 1表示处理中
   */
  private final static Integer PROCESSING_CODE = 1;

  /**
   * -1表示失败
   */
  public final static Integer ERROR_CODE = 0;

  /**
   * 成功，不用返回数据
   *
   * @return ApiResult
   */
  public static <T> ApiResult<T> success() {
    return new ApiResult<>(SUCCESS_CODE, null, null, null);
  }

  /**
   * 成功，返回数据
   *
   * @param data 数据
   * @return ApiResult
   */
  public static <T> ApiResult<T> success(T data) {
    return new ApiResult<>(SUCCESS_CODE, data, null, null);
  }

  /**
   * 失败
   *
   * @param errorData 自定义错误消息
   * @return ApiResult
   */
  public static <T> ApiResult<T> failure(Object errorData) {
    return new ApiResult<>(ERROR_CODE, null, errorData, null);
  }

  /**
   * 失败
   *
   * @param message 失败消息
   * @return ApiResult
   */
  public static <T> ApiResult<T> failure(String message) {
    return new ApiResult<>(ERROR_CODE, null, null, message);
  }

  /**
   * 自定义错误
   *
   * @param errorData 错误集
   * @param message   自定义错误消息
   * @param <T>       T
   * @return ApiResult
   */
  public static <T> ApiResult<T> failure(Object errorData, String message) {
    return new ApiResult<>(ERROR_CODE, null, errorData, message);
  }

  /**
   * 自定义错误
   *
   * @param errorCode 错误码
   * @param message   自定义错误消息
   * @param <T>       T
   * @return ApiResult
   */
  public static <T> ApiResult<T> failure(Integer errorCode, String message) {
    return new ApiResult<>(errorCode, null, null, message);
  }


  /**
   * 失败，自定义错误码和信息
   *
   * @param errorCode 自定义错误码
   * @param message   自定义错误消息
   * @return ApiResult
   */
  public static <T> ApiResult<T> failure(Integer errorCode, Object errorData, String message) {
    return new ApiResult<>(errorCode, null, errorData, message);
  }
}
