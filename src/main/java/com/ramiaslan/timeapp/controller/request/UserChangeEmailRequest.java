package com.ramiaslan.timeapp.controller.request;

import com.ramiaslan.timeapp.validator.UniqueEmail;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class UserChangeEmailRequest implements Request {

    @NotBlank(message = "User name must not be null or empty")
    @Size(min = 3, max = 50, message = "User name size must be between {min} and {max}")
    private String username;

    @UniqueEmail
    @NotBlank(message = "Email must not be null or empty")
    @Size(min = 4, max = 100, message = "Email size must be between {min} and {max}")
    private String email;

}
