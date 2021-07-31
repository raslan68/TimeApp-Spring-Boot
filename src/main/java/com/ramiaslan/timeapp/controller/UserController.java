package com.ramiaslan.timeapp.controller;

import com.ramiaslan.timeapp.controller.request.UserCreateRequest;
import com.ramiaslan.timeapp.controller.request.UserUpdateRequest;
import com.ramiaslan.timeapp.controller.response.GenericResponse;
import com.ramiaslan.timeapp.controller.response.UserResponse;
import com.ramiaslan.timeapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController implements BaseController<UserResponse, UserCreateRequest, UserUpdateRequest> {

    private final UserService userService;

    @Override
    public ResponseEntity<?> create(UserCreateRequest userCreateRequest) {
        userService.create(userCreateRequest);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new GenericResponse(201, "User successfully created."));
    }

    @Override
    public ResponseEntity<?> update(UserUpdateRequest userUpdateRequest) {
        userService.update(userUpdateRequest);
        return ResponseEntity.ok(new GenericResponse(200, "User successfully updated"));
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        userService.delete(id);
        return ResponseEntity.ok(new GenericResponse(200, "User successfully deleted"));
    }

    @Override
    public ResponseEntity<UserResponse> findById(Long id) {
        UserResponse userResponse = userService.findById(id);
        return ResponseEntity.ok(userResponse);
    }

    @Override
    public ResponseEntity<List<UserResponse>> findAll() {
        List<UserResponse> userResponses = userService.findAll();
        return ResponseEntity.ok(userResponses);
    }

    @Override
    public ResponseEntity<List<UserResponse>> slice(Pageable pageable) {
        List<UserResponse> userResponses = userService.slice(pageable);
        return ResponseEntity.ok(userResponses);
    }

}
