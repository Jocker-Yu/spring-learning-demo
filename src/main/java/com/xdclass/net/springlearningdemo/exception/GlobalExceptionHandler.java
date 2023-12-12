package com.xdclass.net.springlearningdemo.exception;


import com.xdclass.net.springlearningdemo.utils.ApiResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(value = Exception.class)
  @ResponseBody
  public ApiResult<?> handle(Exception e) {
    log.error("【GlobalExceptionHandler.handle】{}", e.getMessage());
    if (e instanceof XDException) {
      XDException xdException = (XDException) e;
      return ApiResult.failure(xdException.getErrorCode(), xdException.getMessage());
    } else {
      return ApiResult.failure("OTHER");
    }
  }
}
