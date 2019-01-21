package com.github.hejun.auth;

import com.google.common.net.HttpHeaders;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

@Component
public class JwtAuthProvider extends AuthProvider {

    private static final String NOT_LOGIN = "not login.";

    @Override
    public AuthProviderResponse execute(AuthProviderRequest request) {
        HttpServletRequest httpServletRequest = request.getHttpServletRequest();
        HttpServletResponse httpServletResponse = request.getHttpServletResponse();
        String authorization = this.getAuthorization(httpServletRequest);
        if (Objects.nonNull(authorization)) {
            httpServletRequest.setAttribute(RequestAttributeNames.USER_ID, "");
            String newjwt = "xxxxx"; // check the authorization if valid or not
            httpServletResponse.setHeader(HttpHeaders.AUTHORIZATION, newjwt);
            return AuthProviderResponse.SUCCESS;
        } else {
            return AuthProviderResponse.failed(NOT_LOGIN);
        }
    }

    @Override
    public boolean canExecute(AuthProviderRequest request) {
        return true;
    }

    private String getAuthorization(HttpServletRequest httpServletRequest) {
        String authorization = httpServletRequest.getHeader(HttpHeaders.AUTHORIZATION);
        if (StringUtils.isBlank(authorization)) {
            authorization = (String) httpServletRequest.getSession().getAttribute(RequestAttributeNames.SESSION_TOKEN);
        }

        return authorization;
    }
}
