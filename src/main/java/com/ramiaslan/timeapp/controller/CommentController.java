package com.ramiaslan.timeapp.controller;

import com.ramiaslan.timeapp.controller.request.CommentCreateRequest;
import com.ramiaslan.timeapp.controller.request.CommentUpdateRequest;
import com.ramiaslan.timeapp.controller.response.CommentResponse;
import com.ramiaslan.timeapp.controller.response.GenericResponse;
import com.ramiaslan.timeapp.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
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
        commentService.create(commentCreateRequest);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new GenericResponse(201, "Comment successfully created."));
    }

    @Override
    public ResponseEntity<?> update(CommentUpdateRequest commentUpdateRequest) {
        commentService.update(commentUpdateRequest);
        return ResponseEntity.ok(new GenericResponse(200, "Comment successfully updated"));
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        commentService.delete(id);
        return ResponseEntity.ok(new GenericResponse(200, "Comment successfully deleted"));
    }

    @Override
    public ResponseEntity<CommentResponse> findById(Long id) {
        CommentResponse commentResponse = commentService.findById(id);
        return ResponseEntity.ok(commentResponse);
    }

    @Override
    public ResponseEntity<List<CommentResponse>> findAll() {
        List<CommentResponse> commentResponses = commentService.findAll();
        return ResponseEntity.ok(commentResponses);
    }

    @Override
    public ResponseEntity<List<CommentResponse>> slice(Pageable pageable) {
        List<CommentResponse> commentResponses = commentService.slice(pageable);
        return ResponseEntity.ok(commentResponses);
    }

}
