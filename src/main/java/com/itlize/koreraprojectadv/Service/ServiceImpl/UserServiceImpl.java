package com.itlize.koreraprojectadv.Service.ServiceImpl;

import com.itlize.koreraprojectadv.Entity.User;
import com.itlize.koreraprojectadv.Repository.UserRepository;
import com.itlize.koreraprojectadv.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;



    @Override
    public User saveUser(User user) {

        return userRepository.save(user);
    }

    @Override
    public User findByUserId(Integer userId) {

        return userRepository.findById(userId).orElse(null);
    }

    @Override
    public User findByUsername(String username) {

        return userRepository.findByUserName(username).orElse(null);
    }

    @Override
    public List<User> findAllUsers() {
        return null;
    }

    @Override
    public User updateUsername(String username, User user) {
        return null;
    }

    @Override
    public User updateUserPassword(Integer password, User user) {
        return null;
    }

    @Override
    public User deleteUser(User user) {
        return null;
    }
}
