package demifarquhar01;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import demifarquhar01.repositories.ScheduleRepository;
import demifarquhar01.repositories.inmemory.InMemoryScheduleRepository;


 
 public class InMemoryScheduleRepositoryTest {
 
     private ScheduleRepository repo;
 
     @BeforeEach
     public void setup() {
         repo = new InMemoryScheduleRepository();
     }
 
     @Test
     public void testSaveSchedule() {
         Schedule schedule = new Schedule("schedule1", Arrays.asList(LocalDateTime.of(2025, 4, 27, 9, 0)));
         repo.save(schedule);
 
         assertEquals(1, repo.findAll().size(), "Repository should contain 1 Schedule after saving");
     }
 
     @Test
     public void testFindByIdSchedule() {
         Schedule schedule = new Schedule("schedule2", Arrays.asList(LocalDateTime.of(2025, 4, 28, 10, 0)));
         repo.save(schedule);
 
         Optional<Schedule> found = repo.findById("schedule2");
 
         assertTrue(found.isPresent(), "Schedule should be found by ID");
         assertEquals("schedule2", found.get().getScheduleId(), "Found Schedule ID should match");
     }
 
     @Test
     public void testDeleteSchedule() {
         Schedule schedule = new Schedule("schedule3", Arrays.asList(LocalDateTime.of(2025, 4, 29, 11, 0)));
         repo.save(schedule);
 
         repo.delete("schedule3");
 
         assertFalse(repo.findById("schedule3").isPresent(), "Schedule should not exist after deletion");
     }
 
     @Test
     public void testFindAllSchedules() {
         repo.save(new Schedule("schedule4", Arrays.asList(LocalDateTime.of(2025, 4, 30, 12, 0))));
         repo.save(new Schedule("schedule5", Arrays.asList(LocalDateTime.of(2025, 5, 1, 13, 0))));
 
         assertEquals(2, repo.findAll().size(), "Repository should return all saved Schedules");
     }
 
     @Test
     public void testUpdateSchedule() {
         Schedule schedule = new Schedule("schedule6", Arrays.asList(LocalDateTime.of(2025, 4, 27, 14, 0)));
         repo.save(schedule);
 
         schedule.updateSchedule(Arrays.asList(LocalDateTime.of(2025, 4, 27, 15, 0)));
 
         Optional<Schedule> updatedSchedule = repo.findById("schedule6");
         assertTrue(updatedSchedule.isPresent(), "Schedule should exist after update");
         assertEquals(LocalDateTime.of(2025, 4, 27, 15, 0), updatedSchedule.get().getAvailableSlots().get(0),
                 "Updated slot should match");
     }
 }
    
    
