package com.ramiaslan.timeapp.controller;

import com.ramiaslan.timeapp.controller.request.RoleCreateRequest;
import com.ramiaslan.timeapp.controller.request.RoleUpdateRequest;
import com.ramiaslan.timeapp.controller.response.GenericResponse;
import com.ramiaslan.timeapp.controller.response.RoleResponse;
import com.ramiaslan.timeapp.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
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
        roleService.create(roleCreateRequest);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new GenericResponse(201, "Role successfully created."));
    }

    @Override
    public ResponseEntity<?> update(RoleUpdateRequest roleUpdateRequest) {
        roleService.update(roleUpdateRequest);
        return ResponseEntity.ok(new GenericResponse(200, "Role successfully updated"));
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        roleService.delete(id);
        return ResponseEntity.ok(new GenericResponse(200, "Role successfully deleted"));
    }

    @Override
    public ResponseEntity<RoleResponse> findById(Long id) {
        RoleResponse roleResponse = roleService.findById(id);
        return ResponseEntity.ok(roleResponse);
    }

    @Override
    public ResponseEntity<List<RoleResponse>> findAll() {
        List<RoleResponse> roleResponses = roleService.findAll();
        return ResponseEntity.ok(roleResponses);
    }

    @Override
    public ResponseEntity<List<RoleResponse>> slice(Pageable pageable) {
        List<RoleResponse> roleResponses = roleService.slice(pageable);
        return ResponseEntity.ok(roleResponses);
    }

}
