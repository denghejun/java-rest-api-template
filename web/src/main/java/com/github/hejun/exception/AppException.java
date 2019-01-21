package com.github.hejun.exception;

public class AppException extends RuntimeException {
    private final ErrorCode errorCode;

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public AppException(ErrorCode errorCode) {
        super(errorCode.getDesc());
        this.errorCode = errorCode;
    }

    public AppException(String message, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public AppException(String message, Exception exception) {
        super(message, exception);
        this.errorCode = null;
    }
}
