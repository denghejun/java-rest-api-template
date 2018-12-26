package com.github.hejun.interceptor;

import com.github.hejun.auth.AuthProviderRequest;
import com.github.hejun.auth.AuthProviderResponse;
import com.github.hejun.auth.OpenApiAuthProvider;
import com.github.hejun.exception.AppException;
import com.github.hejun.exception.ErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class OpenApiInterceptor implements HandlerInterceptor {

    @Autowired
    private OpenApiAuthProvider openApiAuthProvider;


    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) {
        AuthProviderRequest request = new AuthProviderRequest(httpServletRequest, httpServletResponse, o);
        AuthProviderResponse response = this.openApiAuthProvider.check(request);
        if (!response.isSuccess()) {
            throw new AppException(response.getMessage(), ErrorCode.SYSTEM_ERROR);
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
