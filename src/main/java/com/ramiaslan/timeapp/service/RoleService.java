package com.ramiaslan.timeapp.service;

import com.ramiaslan.timeapp.controller.request.RoleCreateRequest;
import com.ramiaslan.timeapp.controller.request.RoleUpdateRequest;
import com.ramiaslan.timeapp.controller.response.RoleResponse;
import com.ramiaslan.timeapp.entity.Role;
import com.ramiaslan.timeapp.exception.TimeAppException;
import com.ramiaslan.timeapp.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoleService implements BaseService<RoleResponse, RoleCreateRequest, RoleUpdateRequest> {

    private final RoleRepository roleRepository;

    @Override
    public void create(RoleCreateRequest roleCreateRequest) {
        Role role = new Role();
        role.setName(roleCreateRequest.getRolename());
        roleRepository.save(role);
    }

    @Override
    public void update(RoleUpdateRequest roleUpdateRequest) {
        Role role = roleRepository.findById(roleUpdateRequest.getId())
                .orElseThrow(() -> new TimeAppException("Role not found", HttpStatus.BAD_REQUEST));

        role.setName(roleUpdateRequest.getRolename());

        roleRepository.save(role);
    }

    @Override
    public void delete(Long id) {
        Role role = roleRepository.findById(id)
                .orElseThrow(() -> new TimeAppException("Role not found", HttpStatus.BAD_REQUEST));

        roleRepository.deleteById(role.getId());
    }

    @Override
    public RoleResponse findById(Long id) {
        Role role = roleRepository.findById(id)
                .orElseThrow(() -> new TimeAppException("Role not found", HttpStatus.BAD_REQUEST));

        return convert(role);
    }

    @Override
    public List<RoleResponse> findAll() {
       return roleRepository.findAll().stream()
               .map(this::convert)
               .collect(Collectors.toList());
    }

    @Override
    public List<RoleResponse> slice(Pageable pageable) {
        return roleRepository.findAll(pageable).stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }

    private RoleResponse convert(Role role) {
        RoleResponse roleResponse = new RoleResponse();
        roleResponse.setId(role.getId());
        roleResponse.setName(role.getName());
        roleResponse.setCreatedDate(role.getCreatedDate());
        roleResponse.setLastModifiedDate(role.getLastModifiedDate());
        return roleResponse;
    }

}
