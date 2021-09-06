package com.ramiaslan.timeapp.service;

import com.ramiaslan.timeapp.controller.request.AssignRequest;
import com.ramiaslan.timeapp.controller.request.TaskCreateRequest;
import com.ramiaslan.timeapp.controller.request.TaskUpdateRequest;
import com.ramiaslan.timeapp.controller.response.TaskResponse;
import com.ramiaslan.timeapp.controller.response.TimeFrameResponse;
import com.ramiaslan.timeapp.entity.*;
import com.ramiaslan.timeapp.exception.TimeAppException;
import com.ramiaslan.timeapp.repository.AssignmentRepository;
import com.ramiaslan.timeapp.repository.ProjectRepository;
import com.ramiaslan.timeapp.repository.TaskRepository;
import com.ramiaslan.timeapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskService implements BaseService<TaskResponse, TaskCreateRequest, TaskUpdateRequest> {

    private final TaskRepository taskRepository;
    private final ProjectRepository projectRepository;
    private final AssignmentRepository assignmentRepository;
    private final UserRepository userRepository;

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

    public void assign(AssignRequest assignRequest) {
        Task task = taskRepository.findByName(assignRequest.getTaskname())
                .orElseThrow(() -> new TimeAppException("Taskname not found", HttpStatus.BAD_REQUEST));

        User user = userRepository.findByUsername(assignRequest.getUsername())
                .orElseThrow(() -> new TimeAppException("Username not found ", HttpStatus.BAD_REQUEST));

        Set<Assignment> assignments = new HashSet<>();
        assignments.add(task.getAssignment());

        Set<Task> tasks = new HashSet<>();
        tasks.add(task);

        Set<Project> projects = new HashSet<>();
        projects.add(task.getProject());

        user.setAssignments(assignments);
        user.setTasks(tasks);
        user.setProjects(projects);

        Set<User> users = new HashSet<>();
        users.add(user);

        task.setUsers(users);
        taskRepository.save(task);
    }

    private TaskResponse convert(Task task) {
        Assignment assignment = assignmentRepository.findByTasksId(task.getId())
                .orElseThrow(() -> new TimeAppException("Assignment not found", HttpStatus.BAD_REQUEST));

        List<String> users =  task.getUsers().stream().map(User::getUsername).collect(Collectors.toList());

        TaskResponse taskResponse = new TaskResponse();
        taskResponse.setId(task.getId());
        taskResponse.setName(task.getName());
        taskResponse.setStartDate(task.getStartDate());
        taskResponse.setEndDate(task.getEndDate());
        taskResponse.setStatus(task.getStatus().name());
        taskResponse.setTimeShould(task.getTimeShould());
        taskResponse.setTimeIs(task.getTimeIs());
        taskResponse.setDeltaTime(task.calculateDeltaTime(task.getTimeIs(), task.getTimeShould()));
        taskResponse.setUsernames(users);
        taskResponse.setProjectName(task.getProject().getName());
        taskResponse.setAssignmentId(assignment.getId());
        taskResponse.setCreatedDate(task.getCreatedDate());
        taskResponse.setLastModifiedDate(task.getLastModifiedDate());

        return taskResponse;
    }

}
