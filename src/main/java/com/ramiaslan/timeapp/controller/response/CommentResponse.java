package com.ramiaslan.timeapp.controller.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CommentResponse implements Response {

    private Long id;

    private String description;

    private String taskName;

    private String username;

    private LocalDateTime createdDate;

    private LocalDateTime lastModifiedDate;

}
