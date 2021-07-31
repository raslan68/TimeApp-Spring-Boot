package com.ramiaslan.timeapp.controller.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@Setter
public class ProjectCreateRequest {

    @NotBlank(message = "Project name must not be null or empty")
    @Size(min = 3, max = 150, message = "Project name size must be between {min} and {max}")
    private String name;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate startDate;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate endDate;

    @Positive(message = "Interval must be positive")
    @Range(min = 0, max = 60, message = "Interval size must be between {min} and {max}")
    private Integer interval;

}
