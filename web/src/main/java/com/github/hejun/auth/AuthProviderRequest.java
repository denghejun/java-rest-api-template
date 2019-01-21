package com.github.hejun.auth;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthProviderRequest {
    private HttpServletRequest httpServletRequest;
    private HttpServletResponse httpServletResponse;
    private Object object;

    public AuthProviderRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object) {
        this.httpServletRequest = httpServletRequest;
        this.httpServletResponse = httpServletResponse;
        this.object = object;
    }

    public AuthProviderRequest() {

    }

    public HttpServletRequest getHttpServletRequest() {
        return httpServletRequest;
    }

    public void setHttpServletRequest(HttpServletRequest httpServletRequest) {
        this.httpServletRequest = httpServletRequest;
    }

    public HttpServletResponse getHttpServletResponse() {
        return httpServletResponse;
    }

    public void setHttpServletResponse(HttpServletResponse httpServletResponse) {
        this.httpServletResponse = httpServletResponse;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
