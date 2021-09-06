package com.ramiaslan.timeapp.service;

import com.ramiaslan.timeapp.controller.request.ProjectCreateRequest;
import com.ramiaslan.timeapp.controller.request.ProjectUpdateRequest;
import com.ramiaslan.timeapp.controller.response.ProjectResponse;
import com.ramiaslan.timeapp.controller.response.TaskDto;
import com.ramiaslan.timeapp.entity.Project;
import com.ramiaslan.timeapp.entity.Task;
import com.ramiaslan.timeapp.exception.TimeAppException;
import com.ramiaslan.timeapp.repository.ProjectRepository;
import com.ramiaslan.timeapp.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProjectService implements BaseService<ProjectResponse, ProjectCreateRequest, ProjectUpdateRequest> {

    private final ProjectRepository projectRepository;
    private final TaskRepository taskRepository;

    @Override
    public void create(ProjectCreateRequest projectCreateRequest) {
        Project project = new Project();
        project.setName(projectCreateRequest.getName());
        project.setStartDate(projectCreateRequest.getStartDate());
        project.setEndDate(projectCreateRequest.getEndDate());
        project.setInterval(projectCreateRequest.getInterval());

        projectRepository.save(project);
    }

    @Override
    public void update(ProjectUpdateRequest projectUpdateRequest) {
        Project project = projectRepository.findById(projectUpdateRequest.getId())
                .orElseThrow(() -> new TimeAppException("Project not found", HttpStatus.BAD_REQUEST));

        project.setName(projectUpdateRequest.getName());
        project.setStartDate(projectUpdateRequest.getStartDate());
        project.setEndDate(projectUpdateRequest.getEndDate());
        project.setInterval(projectUpdateRequest.getInterval());

        projectRepository.save(project);
    }

    @Override
    public void delete(Long id) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new TimeAppException("Project not found", HttpStatus.BAD_REQUEST));

        projectRepository.deleteById(project.getId());
    }

    @Override
    public ProjectResponse findById(Long id) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new TimeAppException("Project not found", HttpStatus.BAD_REQUEST));

        return convert(project);
    }

    @Override
    public List<ProjectResponse> findAll() {
        return projectRepository.findAll().stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProjectResponse> slice(Pageable pageable) {
        return projectRepository.findAll(pageable).stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }

    private ProjectResponse convert(Project project) {
        List<Task> tasks = taskRepository.findByProjectId(project.getId());

        ProjectResponse projectResponse = new ProjectResponse();
        projectResponse.setId(project.getId());
        projectResponse.setName(project.getName());
        projectResponse.setStartDate(project.getStartDate());
        projectResponse.setEndDate(project.getEndDate());
        projectResponse.setInterval(project.getInterval());
        projectResponse.setTasks(tasks.stream().map(t ->
             TaskDto.builder()
                     .taskIds(t.getId())
                     .taskNames(t.getName())
                     .build()
        ).collect(Collectors.toList()));
        //projectResponse.setTaskName(tasks.stream().map(Task::getName).collect(Collectors.toList()));
        projectResponse.setCreatedDate(project.getCreatedDate());
        projectResponse.setLastModifiedDate(project.getLastModifiedDate());

        return projectResponse;
    }

}
