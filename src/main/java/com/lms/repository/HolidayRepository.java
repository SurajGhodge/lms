package com.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lms.entity.Holiday;

public interface HolidayRepository extends JpaRepository<Holiday, Integer> {
}
