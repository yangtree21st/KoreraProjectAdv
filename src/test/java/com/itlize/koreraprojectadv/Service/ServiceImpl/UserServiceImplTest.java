package com.itlize.koreraprojectadv.Service.ServiceImpl;

import com.itlize.koreraprojectadv.Entity.Role;
import com.itlize.koreraprojectadv.Entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceImplTest {

    @Autowired
    private UserServiceImpl userService;

    @Test
    public void saveUser() {
        User user = new User();
        user.setUserName("YangManager");
        user.setRole(Role.CostManager);
        user.setPassword("1234567");
        User tester2 = userService.saveUser(user);

        System.out.println(user.getUserName());
        assertNotNull(user);
    }

    @Test
    void findByUserId() {
        User user = userService.findByUserId(1);
        System.out.println(user.getUserName());
        assertEquals(1,user.getUserId());
    }

    @Test
    void findByUsername() {

        User user = userService.findByUsername("YangManager");
        System.out.println(user.getUserName());
        assertEquals("YangManager",user.getUserName());
    }

    @Test
    void findAllUsers() {
    }

    @Test
    void updateUsername() {
    }

    @Test
    void updateUserPassword() {
    }

    @Test
    void deleteUser() {
    }
}