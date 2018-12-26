package com.github.hejun.controller;

import com.github.hejun.model.UserModel;
import com.github.hejun.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.github.hejun.auth.RequestAttributeNames.USER_ID;

@Slf4j
@RestController
@RequestMapping(value = "/user", produces = "application/json; charset=utf-8")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{prefix}")
    public List<UserModel> getUsers(
            @RequestAttribute(USER_ID) String userId,
            @RequestParam(value = "age", required = false) Integer age,
            @PathVariable("prefix") String prefix) {

        log.error("xxxxxxxxxxxx");
        return this.userService.getUsers(prefix, age);
    }
}
