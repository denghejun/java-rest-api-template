package com.github.hejun.service;

import com.github.hejun.aop.AutoLog;
import com.github.hejun.cache.CacheKey;
import com.github.hejun.cache.CacheType;
import com.github.hejun.config.ApplicationYmlConfiguration;
import com.github.hejun.exception.AppException;
import com.github.hejun.exception.ErrorCode;
import com.github.hejun.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class UserService {
    private ApplicationYmlConfiguration applicationConfiguration;

    @Autowired
    public UserService(ApplicationYmlConfiguration applicationConfiguration) {
        this.applicationConfiguration = applicationConfiguration;
    }

//    @AutoLog(metaData = "meta1, meta2")
//    @Cacheable(value = CacheType.THIRTY_SECONDS, key = CacheKey.USER_CACHE_KEY + " + #prefix")
    public List<UserModel> getUsers(String prefix, Integer age) {
        List<UserModel> list = new ArrayList<>();
        UserModel model = new UserModel();
        model.setName("THE ONE");
        model.setAge(999);
        list.add(model);
        return list;

//        return getUserModels(prefix, age, 0);
    }

    @AutoLog(metaData = "meta1, meta2")
    @CachePut(value = CacheType.THIRTY_SECONDS, key = CacheKey.USER_CACHE_KEY + " + #prefix")
    public List<UserModel> refreshUserCache(String prefix, Integer age, Integer count) {
        return getUserModels(prefix, age, count);
    }

    private List<UserModel> getUserModels(String prefix, Integer age, Integer count) {
        if (age != null && age < 0) {
            throw new AppException(ErrorCode.USER_NOT_FOUND);
        }

        List<UserModel> models = this.applicationConfiguration.getUsers();
        for (UserModel model : models) {
            if (Objects.nonNull(age)) {
                model.setAge(age);
            }

            model.setName(prefix + ":" + model.getName());
        }

        for (int i = 0; i < count; i++) {
            UserModel model = new UserModel();
            model.setName("cache");
            model.setAge(i);
            models.add(model);
        }

        return models;
    }
}
