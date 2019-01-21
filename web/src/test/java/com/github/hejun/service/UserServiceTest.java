package com.github.hejun.service;

import com.github.hejun.BaseTest;
import com.github.hejun.exception.AppException;
import com.github.hejun.exception.ErrorCode;
import org.junit.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserServiceTest extends BaseTest {

    @MockBean
    private UserService userService;

    @Test(expected = AppException.class)
    public void should_get_app_exception() {
        UserService service =  mock(UserService.class);
        // given
        AppException e = new AppException(ErrorCode.SYSTEM_ERROR);
        when(service.getUsers(anyString(), anyInt())).thenThrow(e);

        // when
        service.getUsers("", 0);
    }
}