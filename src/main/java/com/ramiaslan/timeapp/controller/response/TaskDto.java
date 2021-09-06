package com.ramiaslan.timeapp.controller.response;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TaskDto {

    private Long taskIds;

    private String taskNames;
}
