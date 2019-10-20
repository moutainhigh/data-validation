package com.byit.entrty;

import com.byit.annotation.annotationselector.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author huangfu
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @NotNull(errorMessage = "User.name不能为null，谢谢")
    private String name;
}
