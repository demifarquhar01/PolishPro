package demifarquhar01.services;
import java.util.List;

import demifarquhar01.SalonOwner;
import demifarquhar01.Service;
import demifarquhar01.repositories.ServiceRepository;

public class ServiceManagementService {

    private final ServiceRepository serviceRepository;

    public ServiceManagementService(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    // Add a new service
    public void addService(SalonOwner owner, Service service) {
        if (isAuthorized(owner)) {
            serviceRepository.save(service);  // Save the new service to the repository
            System.out.println("Service added: " + service.getName());
        } else {
            throw new SecurityException("Only Salon Owners can add services.");
        }
    }

    // Remove a service by name
    public void removeService(SalonOwner owner, String serviceName) {
        if (isAuthorized(owner)) {
            Service service = serviceRepository.findById(serviceName)
                                                .orElseThrow(() -> new IllegalStateException("Service not found."));
            serviceRepository.delete(serviceName);  // Delete the service from the repository
            System.out.println("Service removed: " + serviceName);
        } else {
            throw new SecurityException("Only Salon Owners can remove services.");
        }
    }

    // Update a service
    public void updateService(SalonOwner owner, String existingServiceName, Service updatedService) {
        if (isAuthorized(owner)) {
            Service service = serviceRepository.findById(existingServiceName)
                                                .orElseThrow(() -> new IllegalStateException("Service not found."));
            serviceRepository.save(updatedService);  // Update the service in the repository
            System.out.println("Service updated to: " + updatedService.getName());
        } else {
            throw new SecurityException("Only Salon Owners can update services.");
        }
    }

    // List all services (for reference or testing)
    public List<Service> listAllServices() {
        return serviceRepository.findAll();  // Fetch all services from the repository
    }

    private boolean isAuthorized(SalonOwner owner) {
        System.out.println("Owner ID: " + owner.getUserId());  // Add this for debugging
        return owner != null && owner.getUserId().equals("1");  // Only authorized if ID is "1"
    }
}