package com.github.hejun.auth;

public abstract class AuthProvider implements Command<AuthProviderRequest, AuthProviderResponse> {
    public AuthProviderResponse check(AuthProviderRequest request) {
        if (!this.canExecute(request)) {
            return AuthProviderResponse.CAN_NOT_HANDLE;
        }

        return this.execute(request);
    }
}
