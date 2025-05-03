package demifarquhar01;

  // The RescheduleServiceTest clas
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import demifarquhar01.services.RescheduleService;



public class RescheduleServiceTest {

    private RescheduleService rescheduleService;
    private Schedule schedule;
    private List<LocalDateTime> availableSlots;

    @BeforeEach
    public void setUp() {
        rescheduleService = new RescheduleService();
        availableSlots = new ArrayList<>();
        availableSlots.add(LocalDateTime.of(2025, 5, 1, 10, 0));
        availableSlots.add(LocalDateTime.of(2025, 5, 1, 11, 0));
        schedule = new Schedule("schedule1", availableSlots);
    }

    @Test
    public void testReschedule_successful() {
        LocalDateTime oldDateTime = LocalDateTime.of(2025, 5, 1, 10, 0);
        LocalDateTime newDateTime = LocalDateTime.of(2025, 5, 1, 12, 0);
        String reason = "Client request";

        // Try to reschedule
        boolean result = rescheduleService.reschedule(schedule, oldDateTime, newDateTime, reason);

        // Assert successful reschedule
        assertTrue(result);
        assertTrue(schedule.getAvailableSlots().contains(newDateTime));
        assertFalse(schedule.getAvailableSlots().contains(oldDateTime));
    }

    @Test
    public void testReschedule_oldTimeNotFound() {
        LocalDateTime oldDateTime = LocalDateTime.of(2025, 5, 1, 10, 0);
        LocalDateTime newDateTime = LocalDateTime.of(2025, 5, 1, 12, 0);
        String reason = "Client request";

        // Remove old date from available slots
        availableSlots.remove(oldDateTime);

        // Try to reschedule with an unavailable old time
        boolean result = rescheduleService.reschedule(schedule, oldDateTime, newDateTime, reason);

        // Assert failure due to missing old time
        assertFalse(result);
    }

    @Test
    public void testReschedule_newTimeOccupied() {
        LocalDateTime oldDateTime = LocalDateTime.of(2025, 5, 1, 10, 0);
        LocalDateTime newDateTime = LocalDateTime.of(2025, 5, 1, 11, 0); // Slot already taken
        String reason = "Client request";

        // Try to reschedule to an already occupied slot
        boolean result = rescheduleService.reschedule(schedule, oldDateTime, newDateTime, reason);

        // Assert failure due to occupied new time
        assertFalse(result);
    }

    @Test
    public void testReschedule_missingReason() {
        LocalDateTime oldDateTime = LocalDateTime.of(2025, 5, 1, 10, 0);
        LocalDateTime newDateTime = LocalDateTime.of(2025, 5, 1, 12, 0);
        String reason = "";

        // Try to reschedule with missing reason
        boolean result = rescheduleService.reschedule(schedule, oldDateTime, newDateTime, reason);

        // Assert failure due to missing reason
        assertFalse(result);
    }
}
