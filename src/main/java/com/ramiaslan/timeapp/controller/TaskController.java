package com.ramiaslan.timeapp.controller;

import com.ramiaslan.timeapp.controller.request.TaskCreateRequest;
import com.ramiaslan.timeapp.controller.request.TaskUpdateRequest;
import com.ramiaslan.timeapp.controller.response.TaskResponse;
import com.ramiaslan.timeapp.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/task")
public class TaskController implements BaseController<TaskResponse, TaskCreateRequest, TaskUpdateRequest> {

    private final TaskService taskService;

    @Override
    public ResponseEntity<?> create(TaskCreateRequest taskCreateRequest) {
        return null;
    }

    @Override
    public ResponseEntity<?> update(TaskUpdateRequest taskUpdateRequest) {
        return null;
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<TaskResponse> findById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<List<TaskResponse>> findAll() {
        return null;
    }

    @Override
    public ResponseEntity<List<TaskResponse>> slice(Pageable pageable) {
        return null;
    }
}
