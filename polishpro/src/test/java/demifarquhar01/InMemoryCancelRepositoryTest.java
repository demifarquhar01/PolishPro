package demifarquhar01;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import demifarquhar01.repositories.CancelRepository;
import demifarquhar01.repositories.inmemory.InMemoryCancelRepository;


    // tests/InMemoryCancelRepositoryTest.java
    public class InMemoryCancelRepositoryTest {
        private CancelRepository repo;
    
        @BeforeEach
        public void setup() {
            repo = new InMemoryCancelRepository();
        }
    
        @Test
        public void testSaveCancel() {
            Cancel cancel = new Cancel("cancel1", "Client no-show", LocalDateTime.now());
            repo.save(cancel);
    
            assertEquals(1, repo.findAll().size(), "After saving, repository should have 1 cancellation record");
        }
    
        @Test
        public void testFindByIdCancel() {
            Cancel cancel = new Cancel("cancel2", "Client emergency", LocalDateTime.now());
            repo.save(cancel);
    
            Optional<Cancel> found = repo.findById("cancel2");
    
            assertTrue(found.isPresent(), "Cancellation should be found by ID");
            assertEquals("cancel2", found.get().getCancelId(), "Found cancellation ID should match");
        }
    
        @Test
        public void testDeleteCancel() {
            Cancel cancel = new Cancel("cancel3", "Client changed mind", LocalDateTime.now());
            repo.save(cancel);
    
            repo.delete("cancel3");
    
            assertFalse(repo.findById("cancel3").isPresent(), "Cancellation should not exist after deletion");
        }
    
        @Test
        public void testFindAllCancels() {
            repo.save(new Cancel("cancel4", "Client rescheduled", LocalDateTime.now()));
            repo.save(new Cancel("cancel5", "Weather issues", LocalDateTime.now()));
    
            assertEquals(2, repo.findAll().size(), "Repository should return all saved cancellations");
        }
    }
      
