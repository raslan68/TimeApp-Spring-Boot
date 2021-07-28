package com.ramiaslan.timeapp.service;

import com.ramiaslan.timeapp.controller.request.UserCreateRequest;
import com.ramiaslan.timeapp.controller.request.UserUpdateRequest;
import com.ramiaslan.timeapp.controller.response.UserResponse;
import com.ramiaslan.timeapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements BaseService<UserResponse, UserCreateRequest, UserUpdateRequest> {

    private final UserRepository userRepository;

    @Override
    public void create(UserCreateRequest userCreateRequest) {

    }

    @Override
    public void update(UserUpdateRequest userUpdateRequest) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public UserResponse findById(Long id) {
        return null;
    }

    @Override
    public List<UserResponse> findAll() {
        return null;
    }

    @Override
    public List<UserResponse> slice(Pageable pageable) {
        return null;
    }

}
