package com.lms.controller;

import com.lms.entity.Holiday;
import com.lms.service.HolidayService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/holidays")
public class HolidayController {

    @Autowired
    private HolidayService holidayService;

    @PostMapping("/add")
    public ResponseEntity<Holiday> addHoliday(@RequestBody Holiday holiday) {
        return ResponseEntity.ok(holidayService.addHoliday(holiday));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Holiday> updateHoliday(@PathVariable int id, @RequestBody Holiday holiday) {
        Holiday updated = holidayService.updateHoliday(id, holiday);
        if (updated == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(updated);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Holiday> getHoliday(@PathVariable int id) {
        return ResponseEntity.ok(holidayService.getHolidayById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Holiday>> getAllHolidays() {
        return ResponseEntity.ok(holidayService.getAllHolidays());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteHoliday(@PathVariable int id) {
        holidayService.deleteHoliday(id);
        return ResponseEntity.ok("Holiday deleted successfully");
    }
}
