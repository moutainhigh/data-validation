package com.byit.entrty;

import com.byit.annotation.annotationselector.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * @author huangfu
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @NotBank
    private String name;
    @MobileNumberVerification
    private String phone;
    @LengthValidation(strLength = 12,errorMessage = "id长度不符合规定长度")
    private String id;
    @EmailValidation
    private String email;
    @LengthValidation(minLength = 6,maxLength = 18,errorMessage = "密码长度必须在[6,18]位之间")
    private String password;
}
