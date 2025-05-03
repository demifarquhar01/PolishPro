package demifarquhar01.api;


    import java.time.LocalDateTime;
    import java.util.ArrayList;
    import java.util.List;
    import java.util.Optional;

    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
    import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demifarquhar01.Reschedule;
import demifarquhar01.Schedule;
import demifarquhar01.repositories.RescheduleRepository;
import demifarquhar01.services.RescheduleService;
    
    @RestController
    @RequestMapping("/api/reschedules")
    public class RescheduleController {
    
        private final RescheduleRepository rescheduleRepository;
        private final RescheduleService rescheduleService;
    
        public RescheduleController(RescheduleRepository rescheduleRepository, RescheduleService rescheduleService) {
            this.rescheduleRepository = rescheduleRepository;
            this.rescheduleService = rescheduleService;
        }
    
        // GET /api/reschedules - Fetch all reschedules
        @GetMapping
        public List<Reschedule> getAllReschedules() {
            return rescheduleRepository.findAll();
        }
    
        // POST /api/reschedules - Create a new reschedule
        @PostMapping
        public String createReschedule(@RequestBody Reschedule reschedule) {
            rescheduleRepository.save(reschedule);
            return "Reschedule created successfully.";
        }
    
        // PUT /api/reschedules/{id} - Update an existing reschedule
        @PutMapping("/{id}")
        public String updateReschedule(@PathVariable String id, @RequestBody Reschedule updated) {
            Optional<Reschedule> existing = rescheduleRepository.findById(id);
            if (existing.isPresent()) {
                rescheduleRepository.save(updated);
                return "Reschedule updated.";
            } else {
                return "Reschedule with ID " + id + " not found.";
            }
        }
    
       
@PostMapping("/{id}/reschedule")
public String performReschedule(@PathVariable String id,
                                @RequestBody Reschedule rescheduleRequest) {
    // Prepare dummy available slots including the old date time
    List<LocalDateTime> availableSlots = new ArrayList<>();
    availableSlots.add(rescheduleRequest.getOldDateTime());

    // Create a dummy schedule with required constructor arguments
    Schedule dummySchedule = new Schedule("dummy-schedule-id", availableSlots);

    boolean success = rescheduleService.reschedule(
            dummySchedule,
            rescheduleRequest.getOldDateTime(),
            rescheduleRequest.getNewDateTime(),
            rescheduleRequest.getReason()
    );

    if (success) {
        rescheduleRepository.save(rescheduleRequest);
        return "Reschedule workflow executed successfully.";
    } else {
        return "Reschedule failed. See logs for reason.";
    }
}
    }
