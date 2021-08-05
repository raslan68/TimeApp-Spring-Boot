package com.ramiaslan.timeapp.controller.request;

import com.ramiaslan.timeapp.validator.FieldMatch;
import com.ramiaslan.timeapp.validator.UniqueEmail;
import com.ramiaslan.timeapp.validator.UniqueUsername;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@FieldMatch(first = "password", second = "confirmPassword", message = "The password fields must match")
public class UserCreateRequest implements Request {

    @UniqueUsername
    @NotBlank(message = "User name must not be null or empty")
    @Size(min = 3, max = 50, message = "User name size must be between {min} and {max}")
    private String username;

    @NotBlank(message = "Password must not be null or empty")
    @Size(min = 4, max = 32, message = "Password size must be between {min} and {max}")
    private String password;

    @NotBlank(message = "Confirm password must not be null or empty")
    @Size(min = 4, max = 32, message = "Confirm password size must be between {min} and {max}")
    private String confirmPassword;

    @UniqueEmail
    @NotBlank(message = "Email must not be null or empty")
    @Size(min = 4, max = 100, message = "Email size must be between {min} and {max}")
    private String email;

    @NotBlank(message = "Role name must not be null or empty")
    @Size(min = 3, max = 50, message = "Role name size must be between {min} and {max}")
    private String roleName;

}
