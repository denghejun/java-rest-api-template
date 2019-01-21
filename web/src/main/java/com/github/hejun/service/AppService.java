package com.github.hejun.service;

import com.github.hejun.model.App;
import org.springframework.stereotype.Service;

@Service
public class AppService {
    public App get(String appkey) {
        App app = new App();
        app.setId(Long.parseLong("1"));
        app.setKey("xxx");
        app.setName("my app");
        app.setSecret("yyy");
        return app;
    }
}
