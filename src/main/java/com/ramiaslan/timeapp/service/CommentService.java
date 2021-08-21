package com.ramiaslan.timeapp.service;

import com.ramiaslan.timeapp.controller.request.CommentCreateRequest;
import com.ramiaslan.timeapp.controller.request.CommentUpdateRequest;
import com.ramiaslan.timeapp.controller.response.CommentResponse;
import com.ramiaslan.timeapp.entity.Comment;
import com.ramiaslan.timeapp.entity.Task;
import com.ramiaslan.timeapp.entity.User;
import com.ramiaslan.timeapp.exception.TimeAppException;
import com.ramiaslan.timeapp.repository.CommentRepository;
import com.ramiaslan.timeapp.repository.TaskRepository;
import com.ramiaslan.timeapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentService implements BaseService<CommentResponse, CommentCreateRequest, CommentUpdateRequest> {

    private final CommentRepository commentRepository;
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    @Override
    public void create(CommentCreateRequest commentCreateRequest) {
        Task task = taskRepository.findById(commentCreateRequest.getTaskId())
                .orElseThrow(() -> new TimeAppException("Task not found", HttpStatus.BAD_REQUEST));

        User user = userRepository.findByUsername(commentCreateRequest.getUsername())
                .orElseThrow(() -> new TimeAppException("User not found", HttpStatus.BAD_REQUEST));

        Comment comment = new Comment();
        comment.setDescription(commentCreateRequest.getDescription());
        comment.setTask(task);
        comment.setUser(user);

        commentRepository.save(comment);
    }

    @Override
    public void update(CommentUpdateRequest commentUpdateRequest) {
        Comment comment = commentRepository.findById(commentUpdateRequest.getId())
                .orElseThrow(() -> new TimeAppException("Comment not found", HttpStatus.BAD_REQUEST));
        comment.setDescription(commentUpdateRequest.getDescription());

        commentRepository.save(comment);
    }

    @Override
    public void delete(Long id) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new TimeAppException("Comment not found", HttpStatus.BAD_REQUEST));

        commentRepository.deleteById(comment.getId());
    }

    @Override
    public CommentResponse findById(Long id) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new TimeAppException("Comment not found", HttpStatus.BAD_REQUEST));

        return convert(comment);
    }

    @Override
    public List<CommentResponse> findAll() {
        return commentRepository.findAll().stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }

    @Override
    public List<CommentResponse> slice(Pageable pageable) {
        return commentRepository.findAll(pageable).stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }

    private CommentResponse convert(Comment comment) {
        CommentResponse commentResponse = new CommentResponse();
        commentResponse.setId(comment.getId());
        commentResponse.setDescription(comment.getDescription());
        commentResponse.setTaskName(comment.getTask().getName());
        commentResponse.setUsername(comment.getUser().getUsername());
        commentResponse.setCreatedDate(comment.getCreatedDate());
        commentResponse.setLastModifiedDate(comment.getLastModifiedDate());

        return commentResponse;
    }
}
