package com.ramiaslan.timeapp.service;

import com.ramiaslan.timeapp.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commetRepository;

}
