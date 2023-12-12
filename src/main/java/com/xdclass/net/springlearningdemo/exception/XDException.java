package com.xdclass.net.springlearningdemo.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class XDException extends RuntimeException {

  private Integer errorCode;

  private String message;
}
