package com.ramiaslan.timeapp.service;

import com.ramiaslan.timeapp.controller.request.UserCreateRequest;
import com.ramiaslan.timeapp.controller.request.UserUpdateRequest;
import com.ramiaslan.timeapp.controller.response.TaskDto;
import com.ramiaslan.timeapp.controller.response.UserResponse;
import com.ramiaslan.timeapp.entity.Assignment;
import com.ramiaslan.timeapp.entity.Role;
import com.ramiaslan.timeapp.entity.Task;
import com.ramiaslan.timeapp.entity.User;
import com.ramiaslan.timeapp.exception.TimeAppException;
import com.ramiaslan.timeapp.repository.AssignmentRepository;
import com.ramiaslan.timeapp.repository.RoleRepository;
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
public class UserService implements BaseService<UserResponse, UserCreateRequest, UserUpdateRequest> {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final TaskRepository taskRepository;


    @Override
    public void create(UserCreateRequest userCreateRequest) {
        Role role = roleRepository.findByName(userCreateRequest.getRoleName())
                .orElseThrow(() -> new TimeAppException("Role not found", HttpStatus.BAD_REQUEST));

        User user = new User();
        user.setUsername(userCreateRequest.getUsername());
        user.setPassword(userCreateRequest.getPassword());
        user.setEmail(userCreateRequest.getEmail());
        user.setRole(role);

        userRepository.save(user);
    }

    @Override
    public void update(UserUpdateRequest userUpdateRequest) {
        User user = userRepository.findById(userUpdateRequest.getId())
                .orElseThrow(() -> new TimeAppException("User not found", HttpStatus.BAD_REQUEST));

        Role role = roleRepository.findByName(userUpdateRequest.getRoleName())
                .orElseThrow(() -> new TimeAppException("Role not found", HttpStatus.BAD_REQUEST));

        user.setPassword(userUpdateRequest.getPassword());
        user.setEmail(userUpdateRequest.getEmail());
        user.setRole(role);

        userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new TimeAppException("User not found", HttpStatus.BAD_REQUEST));

        userRepository.deleteById(user.getId());
    }

    @Override
    public UserResponse findById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new TimeAppException("User not found", HttpStatus.BAD_REQUEST));

        return convert(user);
    }

    @Override
    public List<UserResponse> findAll() {
        return userRepository.findAll().stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }

    @Override
    public List<UserResponse> slice(Pageable pageable) {
        return userRepository.findAll(pageable).stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }

    private UserResponse convert(User user) {

        UserResponse userResponse = new UserResponse();
        userResponse.setId(user.getId());
        userResponse.setUsername(user.getUsername());
        userResponse.setEmail(user.getEmail());
        userResponse.setRolename(user.getRole().getName());
        userResponse.setCreatedDate(user.getCreatedDate());
        userResponse.setLastModifiedDate(user.getLastModifiedDate());
        return userResponse;
    }

}
