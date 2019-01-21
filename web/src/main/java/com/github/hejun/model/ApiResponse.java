package com.github.hejun.model;

import com.github.hejun.exception.ErrorCode;
import org.springframework.http.HttpStatus;

public class ApiResponse<T> {
    private ErrorCode errorCode;
    private HttpStatus status = HttpStatus.OK;
    private String message = "";
    private T data;

    public ApiResponse(ErrorCode errorCode, HttpStatus status, String message) {
        this.errorCode = errorCode;
        this.status = status;
        this.message = message;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static ApiResponse error(String message, HttpStatus status, ErrorCode code) {
        return new ApiResponse(code, status, message);
    }
}
