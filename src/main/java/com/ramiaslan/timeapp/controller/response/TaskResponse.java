package com.ramiaslan.timeapp.controller.response;

import com.ramiaslan.timeapp.entity.Assignment;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class TaskResponse implements Response {

    private Long id;

    private String name;

    private LocalDate startDate;

    private LocalDate endDate;

    private String status;

    private Double timeShould;

    private Double timeIs;

    private Double deltaTime;

    private String projectName;

    private Long assignmentId;

    private LocalDateTime createdDate;

    private LocalDateTime lastModifiedDate;

}
