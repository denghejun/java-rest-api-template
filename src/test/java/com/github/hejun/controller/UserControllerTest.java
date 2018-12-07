package com.github.hejun.controller;

import com.github.hejun.Main;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Main.class, properties = "spring.profiles.active = test")
@AutoConfigureMockMvc
public class UserControllerTest {

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