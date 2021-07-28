package com.ramiaslan.timeapp.service;

import com.ramiaslan.timeapp.controller.request.ProjectCreateRequest;
import com.ramiaslan.timeapp.controller.request.ProjectUpdateRequest;
import com.ramiaslan.timeapp.controller.response.ProjectResponse;
import com.ramiaslan.timeapp.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectService implements BaseService<ProjectResponse, ProjectCreateRequest, ProjectUpdateRequest> {

    private final ProjectRepository projectRepository;

    @Override
    public void create(ProjectCreateRequest projectCreateRequest) {

    }

    @Override
    public void update(ProjectUpdateRequest projectUpdateRequest) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public ProjectResponse findById(Long id) {
        return null;
    }

    @Override
    public List<ProjectResponse> findAll() {
        return null;
    }

    @Override
    public List<ProjectResponse> slice(Pageable pageable) {
        return null;
    }
}
