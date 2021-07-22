package com.itlize.koreraprojectadv.Repository;

import com.itlize.koreraprojectadv.Entity.Role;
import com.itlize.koreraprojectadv.Entity.User;
import org.aspectj.lang.annotation.Before;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

   // @BeforeAll
    @Test
    public void saveTest(){
        User user = new User();
        user.setPassword("1234567");
        user.setRole(Role.User);
        user.setUserName("YangTester");
        user.setEmail("yang@itlize.com");

        User Tester1 = userRepository.save(user);
        System.out.println(Tester1.getUserId());
        assertNotNull(Tester1);

    }

    @Test
    public void findByUsername(){
        User user = userRepository.findByUserName("YangTester").orElse(null);
        System.out.println(user.getUserId());
        assertNotNull(user);
    }




}