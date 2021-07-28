package com.ramiaslan.timeapp.controller;

import com.ramiaslan.timeapp.controller.request.CommentCreateRequest;
import com.ramiaslan.timeapp.controller.request.CommentUpdateRequest;
import com.ramiaslan.timeapp.controller.response.CommentResponse;
import com.ramiaslan.timeapp.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/comment")
public class CommentController implements BaseController<CommentResponse, CommentCreateRequest, CommentUpdateRequest> {

    private final CommentService commentService;

    @Override
    public ResponseEntity<?> create(CommentCreateRequest commentCreateRequest) {
        return null;
    }

    @Override
    public ResponseEntity<?> update(CommentUpdateRequest commentUpdateRequest) {
        return null;
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<CommentResponse> findById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<List<CommentResponse>> findAll() {
        return null;
    }

    @Override
    public ResponseEntity<List<CommentResponse>> slice(Pageable pageable) {
        return null;
    }
}
