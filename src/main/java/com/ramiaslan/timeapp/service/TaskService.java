package com.ramiaslan.timeapp.service;

import com.ramiaslan.timeapp.controller.request.TaskCreateRequest;
import com.ramiaslan.timeapp.controller.request.TaskUpdateRequest;
import com.ramiaslan.timeapp.controller.response.TaskResponse;
import com.ramiaslan.timeapp.entity.Assignment;
import com.ramiaslan.timeapp.entity.Project;
import com.ramiaslan.timeapp.entity.Status;
import com.ramiaslan.timeapp.entity.Task;
import com.ramiaslan.timeapp.exception.TimeAppException;
import com.ramiaslan.timeapp.repository.AssignmentRepository;
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
public class TaskService implements BaseService<TaskResponse, TaskCreateRequest, TaskUpdateRequest> {

    private final TaskRepository taskRepository;
    private final ProjectRepository projectRepository;
    private final AssignmentRepository assignmentRepository;

    @Override
    public void create(TaskCreateRequest taskCreateRequest) {
        Project project = projectRepository.findById(taskCreateRequest.getProjectId())
                .orElseThrow(() -> new TimeAppException("Project not found", HttpStatus.BAD_REQUEST));

        boolean exist = assignmentRepository.existsById(taskCreateRequest.getAssignmentId());
        if (exist) {
            Assignment assignment = assignmentRepository.findById(taskCreateRequest.getAssignmentId()).get();

            Task task = new Task();
            task.setName(taskCreateRequest.getName());
            task.setStartDate(taskCreateRequest.getStartDate());
            task.setEndDate(taskCreateRequest.getEndDate());
            task.setStatus(Status.valueOf(taskCreateRequest.getStatus()));
            task.setTimeShould(taskCreateRequest.getTimeShould());
            task.setTimeIs(taskCreateRequest.getTimeIs());
            task.setDeltaTime(task.calculateDeltaTime(taskCreateRequest.getTimeIs(), taskCreateRequest.getTimeShould()));
            task.setProject(project);
            task.setAssignment(assignment);

            taskRepository.save(task);
        } else {
            Assignment assignment = new Assignment();
            Assignment savedAssignment = assignmentRepository.save(assignment);

            Task task = new Task();
            task.setName(taskCreateRequest.getName());
            task.setStartDate(taskCreateRequest.getStartDate());
            task.setEndDate(taskCreateRequest.getEndDate());
            task.setStatus(Status.valueOf(taskCreateRequest.getStatus()));
            task.setTimeShould(taskCreateRequest.getTimeShould());
            task.setTimeIs(taskCreateRequest.getTimeIs());
            task.setDeltaTime(task.calculateDeltaTime(taskCreateRequest.getTimeIs(), taskCreateRequest.getTimeShould()));
            task.setProject(project);
            task.setAssignment(savedAssignment);

            taskRepository.save(task);
        }


    }

    @Override
    public void update(TaskUpdateRequest taskUpdateRequest) {
        Task task = taskRepository.findById(taskUpdateRequest.getId())
                .orElseThrow(() -> new TimeAppException("Task not found", HttpStatus.BAD_REQUEST));

        task.setName(taskUpdateRequest.getName());
        task.setStartDate(taskUpdateRequest.getStartDate());
        task.setEndDate(taskUpdateRequest.getEndDate());
        task.setStatus(Status.valueOf(taskUpdateRequest.getStatus()));
        task.setTimeShould(taskUpdateRequest.getTimeShould());
        task.setTimeIs(taskUpdateRequest.getTimeIs());
        task.setDeltaTime(taskUpdateRequest.getDeltaTime());

        taskRepository.save(task);
    }

    @Override
    public void delete(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new TimeAppException("Task not found", HttpStatus.BAD_REQUEST));

        taskRepository.deleteById(task.getId());
    }

    @Override
    public TaskResponse findById(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new TimeAppException("Task not found", HttpStatus.BAD_REQUEST));

        return convert(task);
    }

    @Override
    public List<TaskResponse> findAll() {
        return taskRepository.findAll().stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }

    @Override
    public List<TaskResponse> slice(Pageable pageable) {
        return taskRepository.findAll(pageable).stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }

    private TaskResponse convert(Task task) {
        Assignment assignment = assignmentRepository.findByTasksId(task.getId())
                .orElseThrow(() -> new TimeAppException("Assignment not found", HttpStatus.BAD_REQUEST));

        TaskResponse taskResponse = new TaskResponse();
        taskResponse.setId(task.getId());
        taskResponse.setName(task.getName());
        taskResponse.setStartDate(task.getStartDate());
        taskResponse.setEndDate(task.getEndDate());
        taskResponse.setStatus(task.getStatus().name());
        taskResponse.setTimeShould(task.getTimeShould());
        taskResponse.setTimeIs(task.getTimeIs());
        taskResponse.setDeltaTime(task.calculateDeltaTime(task.getTimeIs(), task.getTimeShould()));
        taskResponse.setProjectName(task.getProject().getName());
        taskResponse.setAssignmentId(assignment.getId());
        taskResponse.setCreatedDate(task.getCreatedDate());
        taskResponse.setLastModifiedDate(task.getLastModifiedDate());

        return taskResponse;
    }

}
