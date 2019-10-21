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
    @LengthValidation(strLength = 20,errorMessage = "email长度低于20位")
    private String email;
}
