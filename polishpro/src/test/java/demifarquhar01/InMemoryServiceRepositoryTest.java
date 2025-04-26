package demifarquhar01;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import demifarquhar01.repositories.ServiceRepository;
import demifarquhar01.repositories.inmemory.InMemoryServiceRepository;

    
    public class InMemoryServiceRepositoryTest {
    
        private ServiceRepository repository;
    
        @BeforeEach
        public void setUp() {
            repository = new InMemoryServiceRepository();
        }
    
        @Test
        public void testSaveService() {
            Service service = new Service("Gel Manicure", "Basic gel manicure with top coat", 45, 35.0, true);
            repository.save(service);
    
            assertEquals(1, repository.findAll().size(), "Repository should contain 1 service after saving");
        }
    
        @Test
        public void testFindServiceById() {
            Service service = new Service("Acrylic Full Set", "Full set of acrylic extensions", 90, 60.0, true);
            repository.save(service);
    
            assertTrue(repository.findById("Acrylic Full Set").isPresent(), "Service should be found by name");
            assertEquals("Acrylic Full Set", repository.findById("Acrylic Full Set").get().getName(), "Found service name should match");
        }
    
        @Test
        public void testDeleteService() {
            Service service = new Service("Nail Repair", "Repair broken nail enhancements", 20, 10.0, true);
            repository.save(service);
    
            repository.delete("Nail Repair");
    
            assertFalse(repository.findById("Nail Repair").isPresent(), "Service should not exist after deletion");
        }
    
        @Test
        public void testFindAllServices() {
            repository.save(new Service("Gel Polish Application", "Gel polish without manicure", 30, 25.0, true));
            repository.save(new Service("Nail Art Design", "Custom nail art per nail", 20, 15.0, true));
    
            assertEquals(2, repository.findAll().size(), "Repository should return all saved services");
        }
    
        @Test
        public void testOverwriteService() {
            Service service = new Service("Ombre Nails", "Ombre powder nail design", 70, 55.0, true);
            repository.save(service);
    
            // Save a service with the same name but different details
            Service updatedService = new Service("Ombre Nails", "Updated ombre nails with glitter options", 80, 65.0, true);
            repository.save(updatedService);
    
            Service foundService = repository.findById("Ombre Nails").get();
            assertEquals(80, foundService.getDuration(), "Service duration should be updated");
            assertEquals(65.0, foundService.getPrice(), "Service price should be updated");
            assertEquals("Updated ombre nails with glitter options", foundService.getDescription(), "Service description should be updated");
        }
    }
    

    

