package com.github.hejun.modulea;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest( "test.a=Hello")
public class ATest {
    @Autowired
    private A aclass;

    @Test
    public void check() {
        String a = aclass.getA();
    }

    @SpringBootApplication
    static class TestConfiguration {
    }
}