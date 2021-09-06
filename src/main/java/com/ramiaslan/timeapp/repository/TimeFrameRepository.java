package com.ramiaslan.timeapp.repository;

import com.ramiaslan.timeapp.entity.TimeFrame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeFrameRepository extends JpaRepository<TimeFrame, Long> {

}
