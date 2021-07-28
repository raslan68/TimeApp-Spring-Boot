package com.ramiaslan.timeapp.controller;

import com.ramiaslan.timeapp.controller.request.AssignmentCreateRequest;
import com.ramiaslan.timeapp.controller.request.AssignmentUpdateRequest;
import com.ramiaslan.timeapp.controller.response.AssignmentResponse;
import com.ramiaslan.timeapp.service.AssignmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/assignment")
public class AssignmentController implements BaseController<AssignmentResponse, AssignmentCreateRequest, AssignmentUpdateRequest> {

    private final AssignmentService assignmentService;

    @Override
    public ResponseEntity<?> create(AssignmentCreateRequest assignmentCreateRequest) {
        return null;
    }

    @Override
    public ResponseEntity<?> update(AssignmentUpdateRequest assignmentUpdateRequest) {
        return null;
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<AssignmentResponse> findById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<List<AssignmentResponse>> findAll() {
        return null;
    }

    @Override
    public ResponseEntity<List<AssignmentResponse>> slice(Pageable pageable) {
        return null;
    }
}
