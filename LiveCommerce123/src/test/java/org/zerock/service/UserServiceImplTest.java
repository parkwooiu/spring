package org.zerock.service;

import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.UserVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Test // Register User
    public void testRegisterUser() {
        UserVO user = UserVO.builder()
                .username("testUser")
                .password("testPassword")
                .email("test@example.com")
                .shippingAddress("경기도 성남시")
                .shippingPostalCode("18506")
                .build();

        log.info("Before registration: " + user);

        userService.registerUser(user);

        log.info("After registration: " + user);
    }

    @Test // Get User
    public void testGetUser() {
        int userId = 10;

        UserVO user = userService.getUser(userId);

        log.info("Retrieved user: " + user);
    }

    @Test // Update User
    public void testUpdateUser() {
        UserVO user = UserVO.builder()
                .userID(9)
                .username("updatedUser")
                .password("updatedPassword")
                .email("updated@example.com")
                .shippingAddress("경기도 성남시")
                .shippingPostalCode("18506")
                .build();

        log.info("Before update: " + user);

        userService.updateUser(user);

        log.info("After update: " + user);
    }

    @Test // Delete User
    public void testDeleteUser() {   //삭제 실패시 userid와 외래키로 중첩되어있는 테이블이 있는지 확인하기
        int userId = 4;

        userService.deleteUser(userId);

        log.info("User with ID " + userId + " has been deleted.");
    }

    @Test // Login User
    public void testLoginUser() {
        String username = "testUser";
        String password = "testPassword";

        boolean loginResult = userService.loginUser(username, password);

        if (loginResult) {
            log.info("Login successful for user: " + username);
        } else {
            log.info("Login failed for user: " + username);
        }
    }

    @Test // Get User List
    public void testGetUserList() {
        log.info("List of users:");

        userService.getUserList().forEach(user -> log.info(user));
    }

}