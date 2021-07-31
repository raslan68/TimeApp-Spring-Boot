package com.ramiaslan.timeapp.controller.request;

import com.ramiaslan.timeapp.validator.UniqueRolename;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Getter
@Setter
public class RoleUpdateRequest {

    @Positive(message = "id must be positive")
    @NotNull(message = "id must not be null")
    private Integer id;

    @UniqueRolename
    @NotBlank(message = "Role name must not be null or empty")
    @Size(min = 2, max = 50, message = "Role name size must be between {min} and {max}")
    private String rolename;

}
