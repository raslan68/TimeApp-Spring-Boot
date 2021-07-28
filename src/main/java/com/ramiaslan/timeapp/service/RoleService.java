package com.ramiaslan.timeapp.service;

import com.ramiaslan.timeapp.controller.request.RoleCreateRequest;
import com.ramiaslan.timeapp.controller.request.RoleUpdateRequest;
import com.ramiaslan.timeapp.controller.response.RoleResponse;
import com.ramiaslan.timeapp.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleService implements BaseService<RoleResponse, RoleCreateRequest, RoleUpdateRequest> {

    private final RoleRepository roleRepository;

    @Override
    public void create(RoleCreateRequest roleCreateRequest) {

    }

    @Override
    public void update(RoleUpdateRequest roleUpdateRequest) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public RoleResponse findById(Long id) {
        return null;
    }

    @Override
    public List<RoleResponse> findAll() {
        return null;
    }

    @Override
    public List<RoleResponse> slice(Pageable pageable) {
        return null;
    }
}
