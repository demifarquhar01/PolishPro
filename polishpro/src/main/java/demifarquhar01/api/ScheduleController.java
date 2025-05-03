package demifarquhar01.api;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import demifarquhar01.NailTechnician;
import demifarquhar01.Schedule;
import demifarquhar01.services.ScheduleService;

@RestController
@RequestMapping("/api/schedules")
public class ScheduleController {

    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    // Fetch all schedules
    @GetMapping
    public ResponseEntity<List<Schedule>> getAllSchedules() {
        List<Schedule> schedules = scheduleService.getAllSchedules();
        return new ResponseEntity<>(schedules, HttpStatus.OK);
    }

    // Create a new schedule
    @PostMapping
    public ResponseEntity<String> createSchedule(@RequestBody Schedule schedule, @RequestParam String technicianId) {
        try {
            // Construct NailTechnician object (assuming name and other details are fetched from a DB or elsewhere)
            NailTechnician technician = new NailTechnician(technicianId, "Technician Name", "email@example.com", "password");
            scheduleService.addSchedule(technician, schedule); // Pass NailTechnician object here
            return new ResponseEntity<>("Schedule created successfully!", HttpStatus.CREATED);
        } catch (SecurityException e) {
            return new ResponseEntity<>("Error: " + e.getMessage(), HttpStatus.FORBIDDEN);
        }
    }

    // Update an existing schedule
    @PutMapping("/{scheduleId}")
    public ResponseEntity<String> updateSchedule(
            @PathVariable String scheduleId, 
            @RequestBody List<LocalDateTime> newSlots,
            @RequestParam String technicianId) {
        
        try {
            NailTechnician technician = new NailTechnician(technicianId, "", "", ""); // Assuming technician details come from elsewhere
            scheduleService.updateSchedule(technician, scheduleId, newSlots);
            return new ResponseEntity<>("Schedule updated successfully!", HttpStatus.OK);
        } catch (IllegalArgumentException | SecurityException e) {
            return new ResponseEntity<>("Error: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    // Checkout (remove) a schedule
    @PostMapping("/{scheduleId}/checkout")
    public ResponseEntity<String> checkoutSchedule(@PathVariable String scheduleId, @RequestParam String technicianId) {
        try {
            NailTechnician technician = new NailTechnician(technicianId, "", "", ""); // Assuming technician details come from elsewhere
            scheduleService.removeSchedule(technician, scheduleId);
            return new ResponseEntity<>("Schedule checked out successfully!", HttpStatus.OK);
        } catch (IllegalArgumentException | SecurityException e) {
            return new ResponseEntity<>("Error: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}

