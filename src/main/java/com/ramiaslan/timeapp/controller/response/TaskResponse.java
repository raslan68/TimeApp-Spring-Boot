package com.ramiaslan.timeapp.controller.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class TaskResponse {

    private Long id;

    private String name;

    private LocalDateTime startDateTime;

    private LocalDateTime endDateTime;

    private String status;

    private Double timeShould;

    private Double timeIs;

    private Double deltaTime;

    private String projectName;

    private String assignmentId;

    private LocalDateTime createdDate;

    private LocalDateTime lastModifiedDate;

}
