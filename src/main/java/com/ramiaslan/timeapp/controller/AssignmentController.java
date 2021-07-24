package com.ramiaslan.timeapp.controller;

import com.ramiaslan.timeapp.service.AssignmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/assignment")
public class AssignmentController {

    private final AssignmentService assignmentService;

}
