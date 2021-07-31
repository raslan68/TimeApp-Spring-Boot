package com.ramiaslan.timeapp.controller.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UserResponse {

    private Long id;

    private String username;

    private String email;

    private String rolename;

    private LocalDateTime createdDate;

    private LocalDateTime lastModifiedDate;

}
