package com.ramiaslan.timeapp.controller;

import com.ramiaslan.timeapp.controller.request.RoleCreateRequest;
import com.ramiaslan.timeapp.controller.request.RoleUpdateRequest;
import com.ramiaslan.timeapp.controller.response.RoleResponse;
import com.ramiaslan.timeapp.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/role")
public class RoleController implements BaseController<RoleResponse, RoleCreateRequest, RoleUpdateRequest> {

    private final RoleService roleService;

    @Override
    public ResponseEntity<?> create(RoleCreateRequest roleCreateRequest) {
        return null;
    }

    @Override
    public ResponseEntity<?> update(RoleUpdateRequest roleUpdateRequest) {
        return null;
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<RoleResponse> findById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<List<RoleResponse>> findAll() {
        return null;
    }

    @Override
    public ResponseEntity<List<RoleResponse>> slice(Pageable pageable) {
        return null;
    }
}
