package com.github.hejun;

import com.google.common.net.HttpHeaders;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Main.class, properties = "spring.profiles.active = test")
@AutoConfigureMockMvc
public abstract class BaseTest {
    protected org.springframework.http.HttpHeaders getRequestHeader() {
        org.springframework.http.HttpHeaders httpHeaders = new org.springframework.http.HttpHeaders();
        httpHeaders.add(HttpHeaders.AUTHORIZATION, "test-token");
        return httpHeaders;
    }
}
