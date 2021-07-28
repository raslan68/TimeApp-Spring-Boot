package com.ramiaslan.timeapp.controller;

import com.ramiaslan.timeapp.controller.request.UserCreateRequest;
import com.ramiaslan.timeapp.controller.request.UserUpdateRequest;
import com.ramiaslan.timeapp.controller.response.UserResponse;
import com.ramiaslan.timeapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
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
        return null;
    }

    @Override
    public ResponseEntity<?> update(UserUpdateRequest userUpdateRequest) {
        return null;
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<UserResponse> findById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<List<UserResponse>> findAll() {
        return null;
    }

    @Override
    public ResponseEntity<List<UserResponse>> slice(Pageable pageable) {
        return null;
    }

}
