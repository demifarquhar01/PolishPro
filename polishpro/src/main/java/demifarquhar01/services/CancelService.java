package demifarquhar01.services;

import java.time.LocalDateTime;
import java.util.Optional;

import demifarquhar01.Cancel;
import demifarquhar01.repositories.CancelRepository;

public class CancelService {
    private final CancelRepository cancelRepository;

    // Constructor to inject the CancelRepository dependency
    public CancelService(CancelRepository cancelRepository) {
        this.cancelRepository = cancelRepository;
    }

    // Method to create and confirm a cancellation
    public boolean createCancellation(String cancelId, String cancellationReason) {
        if (cancellationReason == null || cancellationReason.isEmpty()) {
            System.out.println("Cancellation failed: Reason is required.");
            return false;
        }

        LocalDateTime cancelDateTime = LocalDateTime.now(); // Use current time for the cancellation date
        Cancel cancel = new Cancel(cancelId, cancellationReason, cancelDateTime);
        
        // Confirm cancellation before saving
        cancel.confirmCancellation();

        // Save the cancellation into the repository
        cancelRepository.save(cancel);
        return true;
    }

    // Method to find and confirm an existing cancellation
    public boolean confirmCancellation(String cancelId) {
        Optional<Cancel> cancelOpt = cancelRepository.findById(cancelId);
        
        if (cancelOpt.isEmpty()) {
            System.out.println("Cancellation not found for ID: " + cancelId);
            return false;
        }

        Cancel cancel = cancelOpt.get();
        cancel.confirmCancellation();  // Confirm the cancellation
        
        // You could also perform additional operations here if necessary
        return true;
    }

    // Method to remove a cancellation from the repository
    public boolean removeCancellation(String cancelId) {
        Optional<Cancel> cancelOpt = cancelRepository.findById(cancelId);
        
        if (cancelOpt.isEmpty()) {
            System.out.println("Cancellation not found for ID: " + cancelId);
            return false;
        }

        cancelRepository.delete(cancelId); // Delete the cancellation
        System.out.println("Cancellation with ID: " + cancelId + " has been removed.");
        return true;
    }
}



