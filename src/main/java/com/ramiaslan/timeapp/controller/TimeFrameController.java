package com.ramiaslan.timeapp.controller;


import com.ramiaslan.timeapp.controller.request.TimeFrameCreateRequest;
import com.ramiaslan.timeapp.controller.request.TimeFrameUpdateRequest;
import com.ramiaslan.timeapp.controller.response.GenericResponse;
import com.ramiaslan.timeapp.controller.response.TimeFrameResponse;
import com.ramiaslan.timeapp.service.TimeFrameService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/time-frame")
public class TimeFrameController implements BaseController<TimeFrameResponse, TimeFrameCreateRequest, TimeFrameUpdateRequest> {

    private final TimeFrameService timeFrameService;

    @Override
    public ResponseEntity<?> create(TimeFrameCreateRequest timeFrameCreateRequest) {
        timeFrameService.create(timeFrameCreateRequest);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new GenericResponse(201, "TimFrame successfully created"));
    }

    @Override
    public ResponseEntity<?> update(TimeFrameUpdateRequest timeFrameUpdateRequest) {
        timeFrameService.update(timeFrameUpdateRequest);
        return ResponseEntity.ok(new GenericResponse(200, "Time Frame successfully updated"));
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        timeFrameService.delete(id);
        return ResponseEntity.ok(new GenericResponse(200, "Time Frame is successfully deleted"));
    }

    @Override
    public ResponseEntity<TimeFrameResponse> findById(Long id) {
        TimeFrameResponse timeFrameResponse =timeFrameService.findById(id);
        return ResponseEntity.ok(timeFrameResponse);
    }

    @Override
    public ResponseEntity<List<TimeFrameResponse>> findAll() {
        List<TimeFrameResponse> timeFrameResponse = timeFrameService.findAll();
        return ResponseEntity.ok(timeFrameResponse);
    }

    @Override
    public ResponseEntity<List<TimeFrameResponse>> slice(Pageable pageable) {
        List<TimeFrameResponse> slice = timeFrameService.slice(pageable);
        return ResponseEntity.ok(slice);
    }
}