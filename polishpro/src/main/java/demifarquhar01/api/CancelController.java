package demifarquhar01.api;

    import java.util.List;

    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.web.bind.annotation.DeleteMapping;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.PathVariable;
    import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import demifarquhar01.Cancel;
import demifarquhar01.repositories.CancelRepository;
import demifarquhar01.services.CancelService;
    
    @RestController
    @RequestMapping("/api/cancel")
    public class CancelController {
    
        private final CancelService cancelService;
        private final CancelRepository cancelRepository;
    
        @Autowired
        public CancelController(CancelService cancelService, CancelRepository cancelRepository) {
            this.cancelService = cancelService;
            this.cancelRepository = cancelRepository;
        }
    
        // GET /api/cancel - Fetch all cancellations
        @GetMapping
        public List<Cancel> getAllCancellations() {
            return cancelRepository.findAll();  // Assuming findAll is in your base Repository
        }
    
        // POST /api/cancel - Create a new cancellation
        @PostMapping
        public String createCancellation(@RequestParam String cancelId,
                                         @RequestParam String cancellationReason) {
            boolean success = cancelService.createCancellation(cancelId, cancellationReason);
            return success ? "Cancellation created." : "Failed to create cancellation.";
        }
    
        // PUT /api/cancel/{id} - Confirm/update cancellation
        @PutMapping("/{id}")
        public String confirmOrUpdate(@PathVariable("id") String cancelId) {
            boolean confirmed = cancelService.confirmCancellation(cancelId);
            return confirmed ? "Cancellation confirmed." : "Cancellation not found.";
        }
    
        // DELETE /api/cancel/{id} - Delete cancellation
        @DeleteMapping("/{id}")
        public String deleteCancellation(@PathVariable("id") String cancelId) {
            boolean removed = cancelService.removeCancellation(cancelId);
            return removed ? "Cancellation removed." : "Cancellation not found.";
        }
    
        // POST /api/cancel/{id}/confirm - Business flow
        @PostMapping("/{id}/confirm")
        public String confirmCancellation(@PathVariable("id") String cancelId) {
            boolean success = cancelService.confirmCancellation(cancelId);
            return success ? "Cancellation confirmed successfully." : "Cancellation not found.";
        }
    }

