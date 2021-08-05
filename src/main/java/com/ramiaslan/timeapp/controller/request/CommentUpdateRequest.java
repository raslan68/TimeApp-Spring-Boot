package com.ramiaslan.timeapp.controller.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Getter
@Setter
public class CommentUpdateRequest implements Request {

    @NotNull(message = "id cannot be null")
    @Positive(message = "id must be positive")
    private Long id;

    @Size(min = 3, max = 250, message = "Description size must be between {min} and {max}")
    private String description;

}
