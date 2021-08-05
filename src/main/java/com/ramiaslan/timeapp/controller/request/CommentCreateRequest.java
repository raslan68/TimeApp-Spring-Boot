package com.ramiaslan.timeapp.controller.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Getter
@Setter
public class CommentCreateRequest implements Request {

    @Size(min = 3, max = 250, message = "Description size must be between {min} and {max}")
    private String description;

    @NotNull(message = "Task id cannot be null")
    @Positive(message = "Task id must be positive")
    private Long taskId;

    @NotBlank(message = "User name must not be null or empty")
    @Size(min = 3, max = 50, message = "User name size must be between {min} and {max}")
    private String username;

}
