package demifarquhar01;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import demifarquhar01.repositories.ClientPreferenceRepository;
import demifarquhar01.repositories.inmemory.InMemoryClientPreferenceRepository;


 
 public class InMemoryClientPreferenceRepositoryTest {
 
     private ClientPreferenceRepository repo;
 
     @BeforeEach
     public void setup() {
         repo = new InMemoryClientPreferenceRepository();
     }
 
     @Test
     public void testSaveClientPreference() {
         ClientPreference preference = new ClientPreference("pref1", "No gel polish", "Allergic to gel");
         repo.save(preference);
 
         assertEquals(1, repo.findAll().size(), "Repository should contain 1 client preference after saving");
     }
 
     @Test
     public void testFindByIdClientPreference() {
         ClientPreference preference = new ClientPreference("pref2", "Prefers short nails", "Likes French tips");
         repo.save(preference);
 
         Optional<ClientPreference> found = repo.findById("pref2");
 
         assertTrue(found.isPresent(), "ClientPreference should be found by ID");
         assertEquals("pref2", found.get().getPreferenceId(), "Found ClientPreference ID should match");
     }
 
     @Test
     public void testDeleteClientPreference() {
         ClientPreference preference = new ClientPreference("pref3", "Natural look", "No glitter");
         repo.save(preference);
 
         repo.delete("pref3");
 
         assertFalse(repo.findById("pref3").isPresent(), "ClientPreference should not exist after deletion");
     }
 
     @Test
     public void testFindAllClientPreferences() {
         repo.save(new ClientPreference("pref4", "Likes dark colors", "Prefers quick appointments"));
         repo.save(new ClientPreference("pref5", "No cuticle cutting", "Sensitive skin"));
 
         assertEquals(2, repo.findAll().size(), "Repository should return all saved client preferences");
     }
 }
    
    

