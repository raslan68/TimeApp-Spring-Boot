package com.ramiaslan.timeapp.controller.response;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class TimeFrameResponse implements Response {

    private Long id;

    private String username;

    private Long assignmentId;

    private LocalDateTime dateTime;

}
