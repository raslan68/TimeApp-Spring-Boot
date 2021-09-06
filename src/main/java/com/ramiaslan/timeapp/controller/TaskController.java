package com.ramiaslan.timeapp.controller;

import com.ramiaslan.timeapp.controller.request.AssignRequest;
import com.ramiaslan.timeapp.controller.request.TaskCreateRequest;
import com.ramiaslan.timeapp.controller.request.TaskUpdateRequest;
import com.ramiaslan.timeapp.controller.response.AssaignResponse;
import com.ramiaslan.timeapp.controller.response.GenericResponse;
import com.ramiaslan.timeapp.controller.response.TaskResponse;
import com.ramiaslan.timeapp.repository.AssignmentRepository;
import com.ramiaslan.timeapp.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/task")
public class TaskController implements BaseController<TaskResponse, TaskCreateRequest, TaskUpdateRequest> {

    private final TaskService taskService;

    @Override
    public ResponseEntity<?> create(TaskCreateRequest taskCreateRequest) {
        taskService.create(taskCreateRequest);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new GenericResponse(201, "Task successfully created."));
    }

    @Override
    public ResponseEntity<?> update(TaskUpdateRequest taskUpdateRequest) {
        taskService.update(taskUpdateRequest);
        return ResponseEntity.ok(new GenericResponse(200, "Task successfully updated"));
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        taskService.delete(id);
        return ResponseEntity.ok(new GenericResponse(200, "Task successfully deleted"));
    }

    @Override
    public ResponseEntity<TaskResponse> findById(Long id) {
        TaskResponse taskResponse = taskService.findById(id);
        return ResponseEntity.ok(taskResponse);
    }

    @Override
    public ResponseEntity<List<TaskResponse>> findAll() {
        List<TaskResponse> taskResponses = taskService.findAll();
        return ResponseEntity.ok(taskResponses);
    }

    @Override
    public ResponseEntity<List<TaskResponse>> slice(Pageable pageable) {
        List<TaskResponse> taskResponses = taskService.slice(pageable);
        return ResponseEntity.ok(taskResponses);
    }
    @PostMapping("/assign")
    public ResponseEntity<?> assign(@Valid @RequestBody AssignRequest assignRequest) {
        taskService.assign(assignRequest);
        return ResponseEntity.ok(new GenericResponse(200, "Task successfully assigned"));
    }

    //  TO DO !!!!!!!!!!!!!
    @GetMapping("/assign/{id}")
    public ResponseEntity<AssaignResponse> assignFindById(@PathVariable(name = "id") Long id) {

        return null;
    }


}
