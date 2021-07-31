package com.ramiaslan.timeapp.controller.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@Setter
public class ProjectUpdateRequest {

    @Positive(message = "id must be positive")
    @NotNull(message = "id cannot be null")
    private Long id;

    @NotBlank(message = "Project name must not be null or empty")
    @Size(min = 3, max = 150, message = "Project name size must be between {min} and {max}")
    private String name;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate startDate;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate endDate;

    @Positive(message = "Interval must be positive")
    private Integer interval;

}
