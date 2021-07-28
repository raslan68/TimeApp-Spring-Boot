package com.ramiaslan.timeapp.controller;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

public interface BaseController<Response, CreateRequest, UpdateRequest> {

    @PostMapping
    ResponseEntity<?> create(@Valid @RequestBody CreateRequest createRequest);

    @PutMapping
    ResponseEntity<?> update(@Valid @RequestBody UpdateRequest updateRequest);

    @DeleteMapping("/{id}")
    ResponseEntity<?> delete(@PathVariable(name = "id") Long id);

    @GetMapping("/{id}")
    ResponseEntity<Response> findById(@PathVariable(name = "id") Long id);

    @GetMapping
    ResponseEntity<List<Response>> findAll();

    @GetMapping("/slice")
    ResponseEntity<List<Response>> slice(Pageable pageable);

}