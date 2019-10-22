package com.byit.test;


import com.byit.entrty.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserTestTest {

    @Autowired
    private UserTest userTest;

    @Test
    public void validation() {
        userTest.validation(new User("123","18738102288",
                "111111111111","huangfusuper@163.com"
        ,"1234567"));
    }
}
