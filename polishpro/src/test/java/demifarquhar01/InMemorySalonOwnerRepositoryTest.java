package demifarquhar01;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import demifarquhar01.repositories.SalonOwnerRepository;
import demifarquhar01.repositories.inmemory.InMemorySalonOwnerRepository;


  
  public class InMemorySalonOwnerRepositoryTest {
  
      private SalonOwnerRepository repo;
  
      @BeforeEach
      public void setup() {
          repo = new InMemorySalonOwnerRepository();
      }
  
      @Test
      public void testSaveSalonOwner() {
          SalonOwner salonOwner = new SalonOwner("owner1", "Demi ", "Demi@example.com", "password123");
          repo.save(salonOwner);
  
          assertEquals(1, repo.findAll().size(), "Repository should contain 1 SalonOwner after saving");
      }
  
      @Test
      public void testFindByIdSalonOwner() {
          SalonOwner salonOwner = new SalonOwner("owner2", "Jane Smith", "jane@example.com", "password456");
          repo.save(salonOwner);
  
          Optional<SalonOwner> found = repo.findById("owner2");
  
          assertTrue(found.isPresent(), "SalonOwner should be found by ID");
          assertEquals("owner2", found.get().getUserId(), "Found SalonOwner ID should match");
      }
  
      @Test
      public void testDeleteSalonOwner() {
          SalonOwner salonOwner = new SalonOwner("owner3", "Mark Lee", "mark@example.com", "password789");
          repo.save(salonOwner);
  
          repo.delete("owner3");
  
          assertFalse(repo.findById("owner3").isPresent(), "SalonOwner should not exist after deletion");
      }
  
      @Test
      public void testFindAllSalonOwners() {
          repo.save(new SalonOwner("owner4", "Sarah Jones", "sarah@example.com", "password101"));
          repo.save(new SalonOwner("owner5", "Chris Brown", "chris@example.com", "password202"));
  
          assertEquals(2, repo.findAll().size(), "Repository should return all saved SalonOwners");
      }
  }
    

