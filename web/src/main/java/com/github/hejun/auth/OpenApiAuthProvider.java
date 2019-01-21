package com.github.hejun.auth;

import com.github.hejun.model.App;
import com.github.hejun.service.AppService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;

@Component
@Slf4j
public class OpenApiAuthProvider extends AuthProvider {
    private static final String ERROR_TIMESTAMP_NULL = "timestamp cannot be null.";
    private static final String ERROR_APPKEY_INVALID = "app key invalid.";
    private static final String ERROR_TIMESTAMP_INVALID = "timestamp invalid.";
    private static final String ERROR_SIGN_NULL = "sign cannot be null.";
    private static final String ERROR_REQUEST_EXPIRED = "request expired.";
    private static final String ERROR_SIGN_INVALID = "sign invalid.";

    private static final String PARAM_APPKEY = "appkey";
    private static final String PARAM_TIMESTAMP = "timestamp";
    private static final String PARAM_SIGN = "sign";

    @Autowired
    private AppService appService;

    @Value("${auth.openApi.expireSeconds}")
    private int requestExpireSeconds;

    @Override
    public AuthProviderResponse execute(AuthProviderRequest request) {
        HttpServletRequest httpServletRequest = request.getHttpServletRequest();
        String appkey = httpServletRequest.getParameter(PARAM_APPKEY);
        String timestamp = httpServletRequest.getParameter(PARAM_TIMESTAMP);
        String sign = httpServletRequest.getParameter(PARAM_SIGN);

        return this.getAuthProviderResponse(appkey, timestamp, sign);
    }

    @Override
    public boolean canExecute(AuthProviderRequest request) {
        return true;
    }

    private AuthProviderResponse getAuthProviderResponse(String appkey, String timestamp, String sign) {
        App app = this.appService.get(appkey);
        DateTime requestDate = null;

        try {
            requestDate = new DateTime(new Timestamp(Long.valueOf(timestamp)).getTime());
        } catch (Exception e) {
//            log.error("time format error", e);
        }


        if (StringUtils.isBlank(timestamp)) {
            return AuthProviderResponse.failed(ERROR_TIMESTAMP_NULL);
        }

        if (StringUtils.isBlank(sign)) {
            return AuthProviderResponse.failed(ERROR_SIGN_NULL);
        }

        if (app == null) {
            return AuthProviderResponse.failed(ERROR_APPKEY_INVALID);
        }

        if (requestDate == null) {

            return AuthProviderResponse.failed(ERROR_TIMESTAMP_INVALID);
        }

        DateTime now = DateTime.now();
        if (!(now.isAfter(requestDate) && now.isBefore(requestDate.plusSeconds(this.requestExpireSeconds)))) {
            return AuthProviderResponse.failed(ERROR_REQUEST_EXPIRED);
        }

        if (!sign.equals(MD5.Encrypt(appkey + app.getSecret() + timestamp))) {
            return AuthProviderResponse.failed(ERROR_SIGN_INVALID);
        }

        return AuthProviderResponse.SUCCESS;
    }
}
