package com.lms.service;

import java.util.List;
import com.lms.entity.Holiday;

public interface HolidayService {
    Holiday addHoliday(Holiday holiday);
    Holiday updateHoliday(int id, Holiday holiday);
    Holiday getHolidayById(int id);
    List<Holiday> getAllHolidays();
    void deleteHoliday(int id);
}
