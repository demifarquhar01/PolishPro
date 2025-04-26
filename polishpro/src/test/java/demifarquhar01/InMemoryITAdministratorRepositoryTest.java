package demifarquhar01;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import demifarquhar01.repositories.ITAdministratorRepository;
import demifarquhar01.repositories.inmemory.InMemoryITAdministratorRepository;


 
 public class InMemoryITAdministratorRepositoryTest {
 
     private ITAdministratorRepository repo;
 
     @BeforeEach
     public void setup() {
         repo = new InMemoryITAdministratorRepository();
     }
 
     @Test
     public void testSaveITAdministrator() {
         ITAdministrator admin = new ITAdministrator("admin1", "Eddie Admin", "Eddie@example.com", "securePass");
         repo.save(admin);
 
         assertEquals(1, repo.findAll().size(), "Repository should contain 1 administrator after saving");
     }
 
     @Test
     public void testFindByIdITAdministrator() {
         ITAdministrator admin = new ITAdministrator("admin2", "Chelsea Admin", "Chelsea@example.com", "pass123");
         repo.save(admin);
 
         Optional<ITAdministrator> found = repo.findById("admin2");
 
         assertTrue(found.isPresent(), "ITAdministrator should be found by ID");
         assertEquals("admin2", found.get().getUserId(), "Found ITAdministrator ID should match");
     }
 
     @Test
     public void testDeleteITAdministrator() {
         ITAdministrator admin = new ITAdministrator("admin3", "Charlie Admin", "charlie@example.com", "pass321");
         repo.save(admin);
 
         repo.delete("admin3");
 
         assertFalse(repo.findById("admin3").isPresent(), "ITAdministrator should not exist after deletion");
     }
 
     @Test
     public void testFindAllITAdministrators() {
         repo.save(new ITAdministrator("admin4", "Jody Admin", "Jody@example.com", "123456"));
         repo.save(new ITAdministrator("admin5", "Jameel Admin", "Jameel@example.com", "abcdef"));
 
         assertEquals(2, repo.findAll().size(), "Repository should return all saved ITAdministrators");
     }
 }
    
    