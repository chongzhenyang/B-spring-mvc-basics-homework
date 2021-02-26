package com.thoughtworks.capacity.gtb.mvc.controller;

import com.thoughtworks.capacity.gtb.mvc.model.User;
import com.thoughtworks.capacity.gtb.mvc.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public void register(@RequestBody User user) {
        userService.createUser(user);
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login(@RequestParam(value = "username") String username,
                        @RequestParam(value = "password") String password) {
        return userService.validateUser(username, password).toString();
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String showAllUsers() {
        return userService.users().toString();
    }
}
