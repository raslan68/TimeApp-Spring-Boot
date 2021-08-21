package com.ramiaslan.timeapp.controller.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class ProjectResponse implements Response {

    private Long id;

    private String name;

    private LocalDate startDate;

    private LocalDate endDate;

    private Integer interval;

    private List<TaskDto> tasks;
    //private List<String> taskName;

    private LocalDateTime createdDate;

    private LocalDateTime lastModifiedDate;

}
