package com.ramiaslan.timeapp.controller.request;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class AssignRequest implements Request {

    @NotBlank
    @Size(min = 3, max = 50, message = "Username name size must be between {min} and {max")
    private String username;

    @NotBlank
    @Size(min = 3, max = 150, message = "Taskname name size must be between {min} and {max")
    private String taskname;

}
