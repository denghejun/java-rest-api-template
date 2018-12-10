package com.github.hejun.controller;

import com.github.hejun.BaseTest;
import com.github.hejun.Main;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

public class UserControllerTest extends BaseTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void should_get_users_success() throws Exception {
        // given
        String requestUrl = "/user/xxx?age=9999";

        // when
        MvcResult result = mockMvc.perform(get(requestUrl)).andReturn();
        String content = result.getResponse().getContentAsString();


        // then
        Assert.assertNotNull(content);
    }
}