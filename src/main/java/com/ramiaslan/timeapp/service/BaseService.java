package com.ramiaslan.timeapp.service;

import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BaseService<Response, CreateRequest, UpdateRequest> {

    void create(CreateRequest createRequest);

    void update(UpdateRequest updateRequest);

    void delete(Long id);

    Response findById(Long id);

    List<Response> findAll();

    List<Response> slice(Pageable pageable);

}
