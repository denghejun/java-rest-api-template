package com.github.hejun.auth;

public class AuthProviderResponse {

    public static final AuthProviderResponse SUCCESS = new AuthProviderResponse(true, true, "");

    public static final AuthProviderResponse CAN_NOT_HANDLE = new AuthProviderResponse(false, true, "");

    private boolean isSuccess;
    private boolean isHandled;
    private String message;

    public AuthProviderResponse(boolean isSuccess, boolean isHandled, String message) {
        this.isSuccess = isSuccess;
        this.message = message;
        this.isHandled = isHandled;
    }

    public static final AuthProviderResponse failed(String message) {
        return new AuthProviderResponse(true, false, message);
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isHandled() {
        return isHandled;
    }

    public void setHandled(boolean handled) {
        isHandled = handled;
    }
}
