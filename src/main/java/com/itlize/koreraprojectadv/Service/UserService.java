package com.itlize.koreraprojectadv.Service;

import com.itlize.koreraprojectadv.Entity.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);

    User findByUserId(Integer userId);

    User findByUsername(String username);

    List<User> findAllUsers();

    public User updateUsername(String username, User user);

    public User updateUserPassword(Integer password, User user);

    public User deleteUser(User user);








}
