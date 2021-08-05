package com.ramiaslan.timeapp.controller.request;

import com.ramiaslan.timeapp.validator.UniqueRolename;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class RoleCreateRequest implements Request {

    @UniqueRolename
    @NotBlank(message = "Role name must not be null or empty")
    @Size(min = 2, max = 50, message = "Role name size must be between {min} and {max}")
    private String rolename;

}
