package com.ramiaslan.timeapp.controller;

import com.ramiaslan.timeapp.controller.request.ProjectCreateRequest;
import com.ramiaslan.timeapp.controller.request.ProjectUpdateRequest;
import com.ramiaslan.timeapp.controller.response.GenericResponse;
import com.ramiaslan.timeapp.controller.response.ProjectResponse;
import com.ramiaslan.timeapp.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/project")
public class ProjectController implements BaseController<ProjectResponse, ProjectCreateRequest, ProjectUpdateRequest> {

    private final ProjectService projectService;

    @Override
    public ResponseEntity<?> create(ProjectCreateRequest projectCreateRequest) {
        projectService.create(projectCreateRequest);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new GenericResponse(201, "Project successfully created."));
    }

    @Override
    public ResponseEntity<?> update(ProjectUpdateRequest projectUpdateRequest) {
        projectService.update(projectUpdateRequest);
        return ResponseEntity.ok(new GenericResponse(200, "Project successfully updated"));
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        projectService.delete(id);
        return ResponseEntity.ok(new GenericResponse(200, "Project successfully deleted"));
    }

    @Override
    public ResponseEntity<ProjectResponse> findById(Long id) {
        ProjectResponse projectResponse = projectService.findById(id);
        return ResponseEntity.ok(projectResponse);
    }

    @Override
    public ResponseEntity<List<ProjectResponse>> findAll() {
        List<ProjectResponse> projectResponses = projectService.findAll();
        return ResponseEntity.ok(projectResponses);
    }

    @Override
    public ResponseEntity<List<ProjectResponse>> slice(Pageable pageable) {
        List<ProjectResponse> projectResponses = projectService.slice(pageable);
        return ResponseEntity.ok(projectResponses);
    }

}
