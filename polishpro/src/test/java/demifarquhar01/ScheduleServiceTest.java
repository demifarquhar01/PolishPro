package demifarquhar01;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import demifarquhar01.repositories.ScheduleRepository;
import demifarquhar01.repositories.inmemory.InMemoryScheduleRepository;
import demifarquhar01.services.ScheduleService;


public class ScheduleServiceTest {

    private ScheduleService scheduleService;
    private ScheduleRepository repository;

    private NailTechnician technicianA;
    private NailTechnician technicianB;

    @BeforeEach
    public void setup() {
        repository = new InMemoryScheduleRepository();
        scheduleService = new ScheduleService(repository);

        technicianA = new NailTechnician("techA", "Alice", "alice@nails.com", "pass123");
        technicianB = new NailTechnician("techB", "Bob", "bob@nails.com", "pass456");
    }

    @Test
    public void testAddOwnSchedule_Success() {
        Schedule schedule = new Schedule("techA", Arrays.asList(LocalDateTime.now().plusHours(1)));
        scheduleService.addSchedule(technicianA, schedule);

        Schedule saved = repository.findById("techA").orElse(null);
        assertNotNull(saved);
        assertEquals("techA", saved.getScheduleId());
    }

    @Test
    public void testAddOtherTechnicianSchedule_Failure() {
        Schedule schedule = new Schedule("techA", Arrays.asList(LocalDateTime.now().plusHours(1)));

        Exception exception = assertThrows(SecurityException.class, () -> {
            scheduleService.addSchedule(technicianB, schedule);
        });

        assertEquals("Technicians can only add their own schedules.", exception.getMessage());
    }

    @Test
    public void testUpdateOwnSchedule_Success() {
        List<LocalDateTime> original = Arrays.asList(LocalDateTime.now().plusHours(1));
        Schedule schedule = new Schedule("techA", original);
        repository.save(schedule);

        List<LocalDateTime> newSlots = Arrays.asList(LocalDateTime.now().plusHours(3), LocalDateTime.now().plusHours(4));
        scheduleService.updateSchedule(technicianA, "techA", newSlots);

        Schedule updated = repository.findById("techA").orElse(null);
        assertNotNull(updated);
        assertEquals(2, updated.getAvailableSlots().size());
    }

    @Test
    public void testUpdateOtherSchedule_Failure() {
        Schedule schedule = new Schedule("techA", Arrays.asList(LocalDateTime.now().plusHours(1)));
        repository.save(schedule);

        Exception exception = assertThrows(SecurityException.class, () -> {
            scheduleService.updateSchedule(technicianB, "techA", Arrays.asList(LocalDateTime.now().plusHours(5)));
        });

        assertEquals("Technicians can only update their own schedules.", exception.getMessage());
    }

    @Test
    public void testRemoveOwnSchedule_Success() {
        Schedule schedule = new Schedule("techA", Arrays.asList(LocalDateTime.now().plusHours(1)));
        repository.save(schedule);

        scheduleService.removeSchedule(technicianA, "techA");

        assertFalse(repository.findById("techA").isPresent());
    }

    @Test
    public void testRemoveOtherSchedule_Failure() {
        Schedule schedule = new Schedule("techA", Arrays.asList(LocalDateTime.now().plusHours(1)));
        repository.save(schedule);

        Exception exception = assertThrows(SecurityException.class, () -> {
            scheduleService.removeSchedule(technicianB, "techA");
        });

        assertEquals("Technicians can only remove their own schedules.", exception.getMessage());
    }
}





