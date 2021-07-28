package com.ramiaslan.timeapp.service;

import com.ramiaslan.timeapp.controller.request.TaskCreateRequest;
import com.ramiaslan.timeapp.controller.request.TaskUpdateRequest;
import com.ramiaslan.timeapp.controller.response.TaskResponse;
import com.ramiaslan.timeapp.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService implements BaseService<TaskResponse, TaskCreateRequest, TaskUpdateRequest> {

    private final TaskRepository taskRepository;

    @Override
    public void create(TaskCreateRequest taskCreateRequest) {

    }

    @Override
    public void update(TaskUpdateRequest taskUpdateRequest) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public TaskResponse findById(Long id) {
        return null;
    }

    @Override
    public List<TaskResponse> findAll() {
        return null;
    }

    @Override
    public List<TaskResponse> slice(Pageable pageable) {
        return null;
    }
}
