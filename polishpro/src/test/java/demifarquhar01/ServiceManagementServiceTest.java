package demifarquhar01;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import demifarquhar01.repositories.ServiceRepository;
import demifarquhar01.repositories.inmemory.InMemoryServiceRepository;
import demifarquhar01.services.ServiceManagementService;

class ServiceManagementServiceTest {

    private ServiceRepository serviceRepository;
    private ServiceManagementService serviceManagementService;
    private SalonOwner authorizedOwner;
    private SalonOwner unauthorizedOwner;

    @BeforeEach
    public void setUp() {
        // Initialize the in-memory repository
        serviceRepository = new InMemoryServiceRepository();
        
        // Initialize the ServiceManagementService with the in-memory repository
        serviceManagementService = new ServiceManagementService(serviceRepository);

        // Set up an authorized owner with ID "1"
        authorizedOwner = new SalonOwner("1", "Authorized Owner", " Salon@gmail.com", "P12345");
        
        // Set up an unauthorized owner with a different ID
        unauthorizedOwner = new SalonOwner("2", "Unauthorized Owner", " Aunotherized@gmail.com","A1223");
    }

    @Test
    void testAddService_AuthorizedOwner_ShouldAddService() {
        // Arrange
        Service service = new Service("Manicure", "Basic manicure service", 30, 20.0, true);

        // Act
        serviceManagementService.addService(authorizedOwner, service);

        // Assert
        Service savedService = serviceRepository.findById("Manicure").orElse(null);
        assertNotNull(savedService);
        assertEquals("Manicure", savedService.getName());
        assertEquals(30, savedService.getDuration());
        assertEquals(20.0, savedService.getPrice());
        assertTrue(savedService.isStatus());
    }

    @Test
    void testAddService_UnauthorizedOwner_ShouldThrowSecurityException() {
        // Arrange
        Service service = new Service("Manicure", "Basic manicure service", 30, 20.0, true);

        // Act & Assert
        SecurityException exception = assertThrows(SecurityException.class, () -> {
            serviceManagementService.addService(unauthorizedOwner, service);
        });
        assertEquals("Only Salon Owners can add services.", exception.getMessage());
    }

    @Test
    void testRemoveService_AuthorizedOwner_ShouldRemoveService() {
        // Arrange
        Service service = new Service("Manicure", "Basic manicure service", 30, 20.0, true);
        serviceRepository.save(service); // Add service first
        
        // Act
        serviceManagementService.removeService(authorizedOwner, "Manicure");

        // Assert
        assertFalse(serviceRepository.findById("Manicure").isPresent());
    }

    @Test
    void testRemoveService_UnauthorizedOwner_ShouldThrowSecurityException() {
        // Arrange
        Service service = new Service("Manicure", "Basic manicure service", 30, 20.0, true);
        serviceRepository.save(service); // Add service first
        
        // Act & Assert
        SecurityException exception = assertThrows(SecurityException.class, () -> {
            serviceManagementService.removeService(unauthorizedOwner, "Manicure");
        });
        assertEquals("Only Salon Owners can remove services.", exception.getMessage());
    }

    @Test
    void testUpdateService_AuthorizedOwner_ShouldUpdateService() {
        // Arrange
        Service service = new Service("Manicure", "Basic manicure service", 30, 20.0, true);
        serviceRepository.save(service); // Add service first
        
        // Update service
        service.modifyService("Manicure Deluxe", "Deluxe manicure with massage", 45, 35.0, true);
        
        // Act
        serviceManagementService.updateService(authorizedOwner, "Manicure", service);

        // Assert
        Service updatedService = serviceRepository.findById("Manicure Deluxe").orElse(null);
        assertNotNull(updatedService);
        assertEquals("Manicure Deluxe", updatedService.getName());
        assertEquals("Deluxe manicure with massage", updatedService.getDescription());
        assertEquals(45, updatedService.getDuration());
        assertEquals(35.0, updatedService.getPrice());
        assertTrue(updatedService.isStatus());
    }

    @Test
    void testUpdateService_UnauthorizedOwner_ShouldThrowSecurityException() {
        // Arrange
        Service service = new Service("Manicure", "Basic manicure service", 30, 20.0, true);
        serviceRepository.save(service); // Add service first
        
        // Act & Assert
        SecurityException exception = assertThrows(SecurityException.class, () -> {
            serviceManagementService.updateService(unauthorizedOwner, "Manicure", service);
        });
        assertEquals("Only Salon Owners can update services.", exception.getMessage());
    }

    @Test
    void testListAllServices_ShouldReturnAllServices() {
        // Arrange
        Service service1 = new Service("Manicure", "Basic manicure service", 30, 20.0, true);
        Service service2 = new Service("Pedicure", "Basic pedicure service", 45, 25.0, true);
        serviceRepository.save(service1);
        serviceRepository.save(service2);
        
        // Act
        List<Service> services = serviceManagementService.listAllServices();
        
        // Assert
        assertNotNull(services);
        assertEquals(2, services.size());
        assertTrue(services.contains(service1));
        assertTrue(services.contains(service2));
    }
}
