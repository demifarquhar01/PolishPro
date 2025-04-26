package demifarquhar01;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import demifarquhar01.repositories.NailTechnicianRepository;
import demifarquhar01.repositories.inmemory.InMemoryNailTechnicianRepository;


 
 public class InMemoryNailTechnicianRepositoryTest {
 
     private NailTechnicianRepository repo;
 
     @BeforeEach
     public void setup() {
         repo = new InMemoryNailTechnicianRepository();
     }
 
     @Test
     public void testSaveNailTechnician() {
         NailTechnician technician = new NailTechnician("tech1", "Alexis Jones", "Alexis@example.com", "pass123");
         repo.save(technician);
 
         assertEquals(1, repo.findAll().size(), "Repository should contain 1 NailTechnician after saving");
     }
 
     @Test
     public void testFindByIdNailTechnician() {
         NailTechnician technician = new NailTechnician("tech2", "Jane Smith", "jane.smith@example.com", "password");
         repo.save(technician);
 
         Optional<NailTechnician> found = repo.findById("tech2");
 
         assertTrue(found.isPresent(), "NailTechnician should be found by ID");
         assertEquals("tech2", found.get().getUserId(), "Found NailTechnician ID should match");
     }
 
     @Test
     public void testDeleteNailTechnician() {
         NailTechnician technician;
         technician = new NailTechnician("tech3", "Emily White", "emily@example.com", "securePass");
         repo.save(technician);
 
         repo.delete("tech3");
 
         assertFalse(repo.findById("tech3").isPresent(), "NailTechnician should not exist after deletion");
     }
 
     @Test
     public void testFindAllNailTechnicians() {
         repo.save(new NailTechnician("tech4", "Cailyn Black", "cailyn@example.com", "pass1244"));
         repo.save(new NailTechnician("tech5", "Patricia Green", "patricia.green@example.com", "pass5668"));
 
         assertEquals(2, repo.findAll().size(), "Repository should return all saved NailTechnicians");
     }
 }
    


