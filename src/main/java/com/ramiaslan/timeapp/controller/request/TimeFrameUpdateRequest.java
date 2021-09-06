package com.ramiaslan.timeapp.controller.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@Setter
public class TimeFrameUpdateRequest implements Request{

    @NotNull(message = "id cannot be null")
    @Positive(message = "id must be positive")
    private Long id;

    @NotBlank(message = "Username must not be null or empty")
    @Size(min = 2, max = 50, message = "Username size must be between {min} and {max}")
    private String username;

    @NotNull(message = "Assignment id cannot be null")
    @Positive(message = "Assignment id must be positive")
    private Long assignmentId;

    private LocalDateTime dateTime = LocalDateTime.now();

}
