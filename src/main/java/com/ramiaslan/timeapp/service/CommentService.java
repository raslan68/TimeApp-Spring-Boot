package com.ramiaslan.timeapp.service;

import com.ramiaslan.timeapp.controller.request.CommentCreateRequest;
import com.ramiaslan.timeapp.controller.request.CommentUpdateRequest;
import com.ramiaslan.timeapp.controller.response.CommentResponse;
import com.ramiaslan.timeapp.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService implements BaseService<CommentResponse, CommentCreateRequest, CommentUpdateRequest> {

    private final CommentRepository commentRepository;

    @Override
    public void create(CommentCreateRequest commentCreateRequest) {

    }

    @Override
    public void update(CommentUpdateRequest commentUpdateRequest) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public CommentResponse findById(Long id) {
        return null;
    }

    @Override
    public List<CommentResponse> findAll() {
        return null;
    }

    @Override
    public List<CommentResponse> slice(Pageable pageable) {
        return null;
    }
}
