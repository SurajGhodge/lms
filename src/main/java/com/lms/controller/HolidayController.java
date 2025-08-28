package com.lms.controller;

import com.lms.entity.Holiday;
import com.lms.service.HolidayService;
import com.lms.service.HolidayServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/holidays")
public class HolidayController {

    @Autowired
    private HolidayService holidayService;

    // --- Thymeleaf Page ---
    @GetMapping("/list")
    public String showHolidayList(Model model) {
        List<Holiday> holidays = holidayService.getAllHolidays();
        model.addAttribute("holidays", holidays);
        return "holidayList";
    }

    // --- APIs ---
    @PostMapping("/add")
    @ResponseBody
    public ResponseEntity<Holiday> addHoliday(@RequestBody Holiday holiday) {
        return ResponseEntity.ok(holidayService.addHoliday(holiday));
    }

    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Holiday> updateHoliday(@PathVariable int id, @RequestBody Holiday holiday) {
        Holiday updated = holidayService.updateHoliday(id, holiday);
        if (updated == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(updated);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Holiday> getHoliday(@PathVariable int id) {
        return ResponseEntity.ok(holidayService.getHolidayById(id));
    }

    @GetMapping("/all")
    @ResponseBody
    public ResponseEntity<List<Holiday>> getAllHolidays() {
        return ResponseEntity.ok(holidayService.getAllHolidays());
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public ResponseEntity<String> deleteHoliday(@PathVariable int id) {
        holidayService.deleteHoliday(id);
        return ResponseEntity.ok("Holiday deleted successfully");
    }
    
    //api for admin
    @GetMapping("/manage")
    public String holidayList(Model model)
    {
    	List<Holiday> holidays=holidayService.getAllHolidays();
    	model.addAttribute("holidays", holidays);
    	return "admin-holiday-list";
    }
}
