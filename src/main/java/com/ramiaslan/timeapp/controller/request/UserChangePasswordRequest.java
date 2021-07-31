package com.ramiaslan.timeapp.controller.request;

import com.ramiaslan.timeapp.validator.FieldMatch;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@FieldMatch(first = "password", second = "confirmPassword", message = "The password fields must match")
public class UserChangePasswordRequest {

    @NotBlank(message = "User name must not be null or empty")
    @Size(min = 3, max = 50, message = "User name size must be between {min} and {max}")
    private String username;

    @NotBlank(message = "Password must not be null or empty")
    @Size(min = 4, max = 32, message = "Password size must be between {min} and {max}")
    private String password;

    @NotBlank(message = "Confirm password must not be null or empty")
    @Size(min = 4, max = 32, message = "Confirm password size must be between {min} and {max}")
    private String confirmPassword;

}
