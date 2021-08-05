package com.ramiaslan.timeapp.controller.response;

import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
public class GenericResponse implements Response {

    private final Integer code;
    private final String message;
    private final String dateTime;

    public GenericResponse(Integer code, String message) {
        this.code = code;
        this.message = message;
        this.dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
    }

}