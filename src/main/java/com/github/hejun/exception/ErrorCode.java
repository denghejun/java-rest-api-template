package com.github.hejun.exception;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

public enum ErrorCode {
    SYSTEM_ERROR(100000, "System Error"),
    USER_NOT_FOUND(100001, "User Not Found");

    private Integer code;
    private String desc;

    ErrorCode(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    @JsonValue
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @JsonCreator
    public static ErrorCode fromCode(Integer code) {
        return Arrays.stream(ErrorCode.values()).filter(o -> o.code.equals(code)).findFirst().orElse(null);
    }
}
