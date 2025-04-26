package demifarquhar01;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import demifarquhar01.repositories.AppointmentRepository;
import demifarquhar01.repositories.inmemory.InMemoryAppointmentRepository;



// tests/InMemoryAppointmentRepositoryTest.java
public class InMemoryAppointmentRepositoryTest {
    private AppointmentRepository repo;

    @BeforeEach
    public void setup() {
        repo = new InMemoryAppointmentRepository();
    }

    @Test
    public void testSaveAppointment() {
        Appointment appointment = new Appointment("a1", LocalDateTime.now(), "Pending");
        repo.save(appointment);

        assertEquals(1, repo.findAll().size(), "After saving, repository should have 1 appointment");
    }

    @Test
    public void testFindByIdAppointment() {
        Appointment appointment = new Appointment("a1", LocalDateTime.now(), "Pending");
        repo.save(appointment);

        Optional<Appointment> found = repo.findById("a1");

        assertTrue(found.isPresent(), "Appointment should be found by ID");
        assertEquals("a1", found.get().getAppointmentId(), "Found appointment ID should match");
    }

    @Test
    public void testDeleteAppointment() {
        Appointment appointment = new Appointment("a3", LocalDateTime.now(), "Pending");
        repo.save(appointment);

        repo.delete("a3");

        assertFalse(repo.findById("a3").isPresent(), "Appointment should not exist after deletion");
    }

    @Test
    public void testFindAllAppointments() {
        repo.save(new Appointment("a4", LocalDateTime.now(), "Pending"));
        repo.save(new Appointment("a5", LocalDateTime.now(), "Pending"));

        assertEquals(2, repo.findAll().size(), "Repository should return all saved appointments");
    }
}

   