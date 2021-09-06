package com.ramiaslan.timeapp.service;

import com.ramiaslan.timeapp.controller.request.TimeFrameCreateRequest;
import com.ramiaslan.timeapp.controller.request.TimeFrameUpdateRequest;
import com.ramiaslan.timeapp.controller.response.TimeFrameResponse;
import com.ramiaslan.timeapp.entity.Assignment;
import com.ramiaslan.timeapp.entity.TimeFrame;
import com.ramiaslan.timeapp.entity.User;
import com.ramiaslan.timeapp.exception.TimeAppException;
import com.ramiaslan.timeapp.repository.AssignmentRepository;
import com.ramiaslan.timeapp.repository.TimeFrameRepository;
import com.ramiaslan.timeapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TimeFrameService implements BaseService<TimeFrameResponse, TimeFrameCreateRequest, TimeFrameUpdateRequest> {

    private final TimeFrameRepository timeFrameRepository;
    private final UserRepository userRepository;
    private final AssignmentRepository assignmentRepository;

    @Override
    public void create(TimeFrameCreateRequest timeFrameCreateRequest) {
        User user = userRepository.findByUsername(timeFrameCreateRequest.getUsername())
                .orElseThrow(() -> new TimeAppException("User not found", HttpStatus.BAD_REQUEST));

        Assignment assignment = assignmentRepository.findById(timeFrameCreateRequest.getAssignmentId())
                .orElseThrow(() -> new TimeAppException("Assignment not found", HttpStatus.BAD_REQUEST));

        TimeFrame timeFrame = new TimeFrame();
        timeFrame.setUser(user);
        timeFrame.setAssignment(assignment);
        timeFrame.setDateTime(timeFrameCreateRequest.getDateTime());
        timeFrameRepository.save(timeFrame);
    }

    @Override
    public void update(TimeFrameUpdateRequest timeFrameUpdateRequest) {
        TimeFrame timeFrame = timeFrameRepository.findById(timeFrameUpdateRequest.getId())
                .orElseThrow(() -> new TimeAppException("Time Frame not found", HttpStatus.BAD_REQUEST));

        User user = userRepository.findByUsername(timeFrameUpdateRequest.getUsername())
                .orElseThrow(() -> new TimeAppException("User not found", HttpStatus.BAD_REQUEST));

        Assignment assignment = assignmentRepository.findById(timeFrameUpdateRequest.getAssignmentId())
                .orElseThrow(() -> new TimeAppException("Assignment not found", HttpStatus.BAD_REQUEST));

        timeFrame.setUser(user);
        timeFrame.setAssignment(assignment);
        timeFrame.setDateTime(timeFrameUpdateRequest.getDateTime());

        timeFrameRepository.save(timeFrame);

    }

    @Override
    public void delete(Long id) {
        TimeFrame timeFrame = timeFrameRepository.findById(id)
                .orElseThrow(() -> new TimeAppException("Time Frame not found", HttpStatus.BAD_REQUEST));
        timeFrameRepository.delete(timeFrame);
    }

    @Override
    public TimeFrameResponse findById(Long id) {
        TimeFrame timeFrame = timeFrameRepository.findById(id)
                .orElseThrow(() -> new TimeAppException("Time Frame not found", HttpStatus.BAD_REQUEST));

        return convert(timeFrame);
    }

    @Override
    public List<TimeFrameResponse> findAll() {

        return timeFrameRepository.findAll().stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }

    @Override
    public List<TimeFrameResponse> slice(Pageable pageable) {

        return timeFrameRepository.findAll(pageable).stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }

    private TimeFrameResponse convert(TimeFrame timeFrame) {
        TimeFrameResponse timeFrameResponse = new TimeFrameResponse();
        timeFrameResponse.setId(timeFrame.getId());
        timeFrameResponse.setUsername(timeFrame.getUser().getUsername());
        timeFrameResponse.setAssignmentId(timeFrame.getAssignment().getId());
        timeFrameResponse.setDateTime(timeFrame.getDateTime());

        return timeFrameResponse;
    }
}
