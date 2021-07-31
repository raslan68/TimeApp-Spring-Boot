package com.ramiaslan.timeapp.controller.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@Setter
public class TaskUpdateRequest {

    @NotNull(message = "id cannot be null")
    @Positive(message = "id must be positive")
    private Long id;

    @NotBlank(message = "Task name must not be null or empty")
    @Size(min = 3, max = 150, message = "Task name size must be between {min} and {max}")
    private String name;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime startDate;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime endDate;

    @NotBlank(message = "Status cannot must not be null or empty")
    @Size(min = 2, max = 25, message = "Status size must be between {min} and {max}")
    private String status;

    @NotNull(message = "Time should cannot be null")
    private Double timeShould;

    private Double timeIs;

    private Double deltaTime;

    @NotNull(message = "Assignment id cannot be null")
    @Positive(message = "Assignment id must be positive")
    private Long assignmentId;

}
