package com.ramiaslan.timeapp.service;

import com.ramiaslan.timeapp.controller.request.AssignmentCreateRequest;
import com.ramiaslan.timeapp.controller.request.AssignmentUpdateRequest;
import com.ramiaslan.timeapp.controller.response.AssignmentResponse;
import com.ramiaslan.timeapp.repository.AssignmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AssignmentService implements BaseService<AssignmentResponse, AssignmentCreateRequest, AssignmentUpdateRequest> {

    private final AssignmentRepository assignmentRepository;

    @Override
    public void create(AssignmentCreateRequest assignmentCreateRequest) {

    }

    @Override
    public void update(AssignmentUpdateRequest assignmentUpdateRequest) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public AssignmentResponse findById(Long id) {
        return null;
    }

    @Override
    public List<AssignmentResponse> findAll() {
        return null;
    }

    @Override
    public List<AssignmentResponse> slice(Pageable pageable) {
        return null;
    }
}
