package com.github.hejun.auth;

public interface Command<TRequest, TResponse> {
    TResponse execute(TRequest request);

    boolean canExecute(TRequest request);
}
