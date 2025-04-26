package demifarquhar01;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import demifarquhar01.repositories.RescheduleRepository;
import demifarquhar01.repositories.inmemory.InMemoryRescheduleRepository;



public class InMemoryRescheduleRepositoryTest {

    private RescheduleRepository repo;

    @BeforeEach
    public void setup() {
        repo = new InMemoryRescheduleRepository();
    }

    @Test
    public void testSaveReschedule() {
        Reschedule reschedule = new Reschedule("resch1", LocalDateTime.of(2025, 4, 26, 14, 30), LocalDateTime.of(2025, 4, 27, 10, 0), "Client request");
        repo.save(reschedule);

        assertEquals(1, repo.findAll().size(), "Repository should contain 1 Reschedule after saving");
    }

    @Test
    public void testFindByIdReschedule() {
        Reschedule reschedule = new Reschedule("resch2", LocalDateTime.of(2025, 4, 26, 14, 30), LocalDateTime.of(2025, 4, 27, 10, 0), "Staff availability");
        repo.save(reschedule);

        Optional<Reschedule> found = repo.findById("resch2");

        assertTrue(found.isPresent(), "Reschedule should be found by ID");
        assertEquals("resch2", found.get().getRescheduleId(), "Found Reschedule ID should match");
    }

    @Test
    public void testDeleteReschedule() {
        Reschedule reschedule = new Reschedule("resch3", LocalDateTime.of(2025, 4, 26, 14, 30), LocalDateTime.of(2025, 4, 27, 10, 0), "Emergency");
        repo.save(reschedule);

        repo.delete("resch3");

        assertFalse(repo.findById("resch3").isPresent(), "Reschedule should not exist after deletion");
    }

    @Test
    public void testFindAllReschedules() {
        repo.save(new Reschedule("resch4", LocalDateTime.of(2025, 4, 26, 14, 30), LocalDateTime.of(2025, 4, 27, 10, 0), "Client request"));
        repo.save(new Reschedule("resch5", LocalDateTime.of(2025, 4, 27, 11, 0), LocalDateTime.of(2025, 4, 28, 9, 0), "Staff availability"));

        assertEquals(2, repo.findAll().size(), "Repository should return all saved Reschedules");
    }
}

