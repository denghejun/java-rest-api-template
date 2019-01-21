package com.github.hejun.schedule;

import com.github.hejun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class UserServiceCacheUpdateTask {
    @Autowired
    private UserService userService;

    @Scheduled(fixedDelayString = "${schedule.cache.refreshInterval}")
    public void refreshAllUsersCache() {
        String prefix = "xxx";
        Integer age = 10000;
        Integer count = 5;

        this.userService.refreshUserCache(prefix, age, count);
    }
}
