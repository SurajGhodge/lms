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
    private HolidayServiceImpl holidayService;

    // --- Thymeleaf Page ---
    @GetMapping("/list")
    public String showHolidayList(Model model) {
      List<Holiday> holidays = holidayService.getAllHolidays();
        model.addAttribute("holidays", holidays);
        return "holidayList";
    }

    // --- APIs ---
    @PostMapping("/add")
   public String saveHoliday(@ModelAttribute("holiday") Holiday holiday)
   {
    	holidayService.addHoliday(holiday);
    	return "redirect:/holidays/manage";
   }

 
    
    //api for admin
    @GetMapping("/manage")
    public String holidayList(Model model)
    {
    	List<Holiday> holidays=holidayService.getAllHolidays();
    	model.addAttribute("holidays", holidays);
    	model.addAttribute("holiday",new Holiday());
    	return "admin-holiday-list";
    }
  
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") int id, Model model) {
        Holiday holiday = holidayService.getHolidayById(id);
        model.addAttribute("holiday", holiday);
        model.addAttribute("holidays", holidayService.getAllHolidays()); // also reload list
        return "admin-holiday-list"; // ✅ use your existing file
    }

    // ✅ Handle delete
    @GetMapping("/delete/{id}")
    public String deleteHoliday(@PathVariable("id") int id) {
        holidayService.deleteHoliday(id);
        return "redirect:/holidays/manage";
    }
}
