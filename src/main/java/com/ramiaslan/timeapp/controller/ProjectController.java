package com.ramiaslan.timeapp.controller;

import com.ramiaslan.timeapp.controller.request.ProjectCreateRequest;
import com.ramiaslan.timeapp.controller.request.ProjectUpdateRequest;
import com.ramiaslan.timeapp.controller.response.ProjectResponse;
import com.ramiaslan.timeapp.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
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
        return null;
    }

    @Override
    public ResponseEntity<?> update(ProjectUpdateRequest projectUpdateRequest) {
        return null;
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<ProjectResponse> findById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<List<ProjectResponse>> findAll() {
        return null;
    }

    @Override
    public ResponseEntity<List<ProjectResponse>> slice(Pageable pageable) {
        return null;
    }
}
