package com.github.hejun.exception;

import com.github.hejun.model.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
@Slf4j
public class AppExceptionAdvice {

    @Order(1)
    @ExceptionHandler(AppException.class)
    public ApiResponse<Object> handleAppException(AppException e) {
//        log.error("AppException", e);
        return ApiResponse.error(e.getMessage(), HttpStatus.BAD_REQUEST, e.getErrorCode());
    }

    @Order(2)
    @ExceptionHandler(Exception.class)
    public ApiResponse<Object> handleException(Exception e) {
//        log.error("unhandled exception", e);
        return ApiResponse.error(Messages.SYSTEM_ERROR, HttpStatus.INTERNAL_SERVER_ERROR, ErrorCode.SYSTEM_ERROR);
    }
}
