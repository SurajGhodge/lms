package com.lms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.entity.Holiday;
import com.lms.repository.HolidayRepository;

@Service
public class HolidayServiceImpl implements HolidayService {

    @Autowired
    private HolidayRepository holidayRepository;

    @Override
    public Holiday addHoliday(Holiday holiday) {
        return holidayRepository.save(holiday);
    }

    @Override
    public Holiday updateHoliday(int id, Holiday holiday) {
        Optional<Holiday> existing = holidayRepository.findById(id);
        if (existing.isPresent()) {
            Holiday existingHoliday = existing.get();
            existingHoliday.setHolidayName(holiday.getHolidayName());
            existingHoliday.setDate(holiday.getDate());
            existingHoliday.setDay(holiday.getDay());
            return holidayRepository.save(existingHoliday);
        }
        return null;
    }

    @Override
    public Holiday getHolidayById(int id) {
        return holidayRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Holiday not found with id: " + id));
    }

    @Override
    public List<Holiday> getAllHolidays() {
        return holidayRepository.findAll();
    }

    @Override
    public void deleteHoliday(int id) {
        holidayRepository.deleteById(id);
    }
}
