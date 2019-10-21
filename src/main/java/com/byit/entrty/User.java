package com.byit.entrty;

import com.byit.annotation.annotationselector.MobileNumberVerification;
import com.byit.annotation.annotationselector.NotBank;
import com.byit.annotation.annotationselector.NotNull;
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
}
