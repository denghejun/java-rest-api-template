package com.github.hejun.controller;

import com.github.hejun.BaseTest;
import com.github.hejun.Main;
import com.github.hejun.model.UserModel;
import com.github.hejun.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.StringContains.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class UserControllerTest extends BaseTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    UserService userService;

    @InjectMocks
    @Autowired
    UserController userController;

    @Test
    public void should_get_users_success() throws Exception {
        // given
        String requestUrl = "/user/xxx?age=9999";
        List<UserModel> list = new ArrayList<>();
        UserModel model = new UserModel();
        model.setName("THE ONE TEST11111111");
        model.setAge(999);
        list.add(model);
        when(userService.getUsers(any(), any())).thenReturn(list);

        // when & then
        mockMvc.perform(get(requestUrl)
                .headers(this.getRequestHeader()))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().string(containsString("THE ONE TEST11111111")));
    }

    @Test
    public void should_post_users_success() throws Exception {
        // given
        String requestUrl = "/user/post/xxx?age=9999";
        List<UserModel> list = new ArrayList<>();
        UserModel model = new UserModel();
        model.setName("THE ONE TEST11111111");
        model.setAge(999);
        list.add(model);
        when(userService.getUsers(any(), any())).thenReturn(list);

        // when & then
        mockMvc.perform(post(requestUrl)
                .contentType(MediaType.APPLICATION_JSON)
                .headers(this.getRequestHeader()))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().string(containsString("THE ONE TEST11111111")));
    }
}