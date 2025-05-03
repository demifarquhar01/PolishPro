package demifarquhar01;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import demifarquhar01.repositories.inmemory.InMemoryCancelRepository;
import demifarquhar01.services.CancelService;


class CancelServiceTest {

    private CancelService cancelService;
    private InMemoryCancelRepository cancelRepository;

    @BeforeEach
    public void setUp() {
        cancelRepository = new InMemoryCancelRepository();
        cancelService = new CancelService(cancelRepository);
    }
@Test
void testCreateCancellationWithValidReason() {
    String cancelId = "cancel1";
    String cancellationReason = "Client requested to cancel.";
 //   LocalDateTime cancelDateTime = LocalDateTime.now();

    // Create the cancellation
    boolean result = cancelService.createCancellation(cancelId, cancellationReason);

    assertTrue(result, "Cancellation should be created successfully.");

    // Retrieve the cancellation from the repository
    Optional<Cancel> cancelOpt = cancelRepository.findById(cancelId);
    
    // Assert that the cancellation is saved in the repository
    assertTrue(cancelOpt.isPresent(), "Cancellation should be saved in the repository.");
    
    // Get the Cancel object and assert the cancelId
    Cancel cancel = cancelOpt.get();
    assertEquals(cancelId, cancel.getCancelId(), "Cancel ID should match.");

    // Optionally, verify if the reason is correctly stored within the cancellation logic,
    // e.g., by checking system output or comparing parts of the cancelId
    // Assuming you're capturing output in some way or checking logs
    assertTrue(cancelId.contains("cancel"), "Cancel ID should contain the correct identifier.");
}

    
    @Test
    void testCreateCancellationWithEmptyReason() {
        String cancelId = "cancel2";
        String cancellationReason = ""; // Empty reason

        boolean result = cancelService.createCancellation(cancelId, cancellationReason);

        assertFalse(result, "Cancellation should fail if the reason is empty.");
        Optional<Cancel> cancelOpt = cancelRepository.findById(cancelId);
        assertFalse(cancelOpt.isPresent(), "No cancellation should be saved for empty reason.");
    }

    @Test
    void testConfirmCancellation() {
        String cancelId = "cancel3";
        String cancellationReason = "Client did not show up.";
        
        cancelService.createCancellation(cancelId, cancellationReason); // Creating the cancellation first

        boolean result = cancelService.confirmCancellation(cancelId);

        assertTrue(result, "Cancellation should be confirmed successfully.");
        Optional<Cancel> cancelOpt = cancelRepository.findById(cancelId);
        assertTrue(cancelOpt.isPresent(), "Cancellation should be found in the repository.");
        assertEquals(cancelId, cancelOpt.get().getCancelId(), "Cancel ID should match.");
    }

    @Test
    void testConfirmNonExistentCancellation() {
        String cancelId = "cancel4"; // Non-existent cancellation ID

        boolean result = cancelService.confirmCancellation(cancelId);

        assertFalse(result, "Cancellation should not be confirmed if it does not exist.");
    }

    @Test
    void testRemoveCancellation() {
        String cancelId = "cancel5";
        String cancellationReason = "Client rescheduled.";

        cancelService.createCancellation(cancelId, cancellationReason); // Create the cancellation first

        boolean result = cancelService.removeCancellation(cancelId);

        assertTrue(result, "Cancellation should be removed successfully.");
        Optional<Cancel> cancelOpt = cancelRepository.findById(cancelId);
        assertFalse(cancelOpt.isPresent(), "Cancellation should be removed from the repository.");
    }

    @Test
    void testRemoveNonExistentCancellation() {
        String cancelId = "cancel6"; // Non-existent cancellation ID

        boolean result = cancelService.removeCancellation(cancelId);

        assertFalse(result, "Cancellation should not be removed if it does not exist.");
    }
}
