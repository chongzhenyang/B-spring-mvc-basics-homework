package com.thoughtworks.capacity.gtb.mvc.service;

import com.thoughtworks.capacity.gtb.mvc.model.User;

import java.util.List;


public interface UserService {
    void createUser(User user);
    User validateUser(String username, String password);
    List<User> users();
}
