package com.github.hejun.service;

import com.github.hejun.config.ApplicationConfiguration;
import com.github.hejun.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserService {
    private ApplicationConfiguration applicationConfiguration;

    @Autowired
    public UserService(ApplicationConfiguration applicationConfiguration) {
        this.applicationConfiguration = applicationConfiguration;
    }

    public List<UserModel> getUsers(String prefix, Integer age) {
        List<UserModel> models = this.applicationConfiguration.getUsers();
        for (UserModel model : models) {
            if (Objects.nonNull(age)) {
                model.setAge(age);
            }

            model.setName(prefix + ":" + model.getName());
        }

        return models;
    }
}
