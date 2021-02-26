package com.thoughtworks.capacity.gtb.mvc.service;

import com.thoughtworks.capacity.gtb.mvc.error.UserNotFoundException;
import com.thoughtworks.capacity.gtb.mvc.model.User;
import com.thoughtworks.capacity.gtb.mvc.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public void createUser(User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        System.out.println(username);
        if (username == null) {
            throw new IllegalArgumentException("用户名不为空");
        }
        if (userRepository.existsUsersByUsername(username)) {
            throw new IllegalArgumentException("用户名已存在");
        }
        if (password == null) {
            throw new IllegalArgumentException("密码不为空");
        }
        if (!username.matches("^[0-9a-zA-Z_]+$") || username.length() < 3 || username.length() > 10) {
            throw new IllegalArgumentException("用户名不合法");
        }
        if (password.length() < 5 || password.length() > 12) {
            throw new IllegalArgumentException("密码不合法");
        }
        if (!user.getEmail().matches("^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$")) {
            throw new IllegalArgumentException("邮箱不合法");
        }

        userRepository.save(user);
    }

    @Override
    public User validateUser(String username, String password) {
        List<User> userList = userRepository.findUserByUsername(username);
        List<User> validUsers = userList.stream().filter(user -> user.getPassword()
                .equals(password)).collect(Collectors.toList());
        if (validUsers.size() != 1) {
            throw new UserNotFoundException("用户名或密码错误");
        }
        return validUsers.get(0);
    }

    @Override
    public List<User> users() {
        return userRepository.findAll();
    }
}
