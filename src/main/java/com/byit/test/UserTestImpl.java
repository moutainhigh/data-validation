package com.byit.test;

import com.byit.annotation.DataValidation;
import com.byit.entrty.User;
import org.springframework.stereotype.Service;

@Service
public class UserTestImpl implements UserTest {


    @Override
    @DataValidation
    public void validation(User user) {
        System.out.println(user+"-----------------");
    }
}
