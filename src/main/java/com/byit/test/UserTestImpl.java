package com.byit.test;

import com.byit.annotation.DataValidation;
import com.byit.annotation.ParamValidation;
import com.byit.entrty.User;
import org.springframework.stereotype.Service;

@Service
public class UserTestImpl implements UserTest {


    @Override
    @DataValidation
    public void validation(@ParamValidation User user) {
        System.out.println(user+"-----------------");
    }
}
