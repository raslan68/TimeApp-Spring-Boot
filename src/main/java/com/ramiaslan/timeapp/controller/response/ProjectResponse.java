package com.ramiaslan.timeapp.controller.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class ProjectResponse {

    private Long id;

    private String name;

    private LocalDate startDate;

    private LocalDate endDate;

    private Integer interval;

    private LocalDateTime createdDate;

    private LocalDateTime lastModifiedDate;

}
