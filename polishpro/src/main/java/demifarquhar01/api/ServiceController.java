package demifarquhar01.api;

    import java.util.List;

    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.DeleteMapping;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.PathVariable;
    import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import demifarquhar01.SalonOwner;
import demifarquhar01.Service;
import demifarquhar01.services.ServiceManagementService;
    
    @RestController
    @RequestMapping("/api/services")
    public class ServiceController {
    
        @Autowired
        private ServiceManagementService serviceManagementService;
    
        // 1. Fetch all services
        @GetMapping
        public ResponseEntity<List<Service>> getAllServices() {
            List<Service> services = serviceManagementService.listAllServices();
            return new ResponseEntity<>(services, HttpStatus.OK);
        }
    
        // 2. Create a new service
        @PostMapping
        public ResponseEntity<String> addService(@RequestBody Service service, @RequestParam String ownerId, 
                                                  @RequestParam String name, @RequestParam String email, 
                                                  @RequestParam String password) {
            SalonOwner owner = new SalonOwner(ownerId, name, email, password);  // Create the SalonOwner object
            try {
                serviceManagementService.addService(owner, service);
                return new ResponseEntity<>("Service added successfully!", HttpStatus.CREATED);
            } catch (SecurityException e) {
                return new ResponseEntity<>(e.getMessage(), HttpStatus.FORBIDDEN);
            }
        }
    
        // 3. Update an existing service
        @PutMapping("/{serviceName}")
        public ResponseEntity<String> updateService(@PathVariable String serviceName, 
                                                    @RequestBody Service updatedService, 
                                                    @RequestParam String ownerId, @RequestParam String name, 
                                                    @RequestParam String email, @RequestParam String password) {
            SalonOwner owner = new SalonOwner(ownerId, name, email, password);  // Create the SalonOwner object
            try {
                serviceManagementService.updateService(owner, serviceName, updatedService);
                return new ResponseEntity<>("Service updated successfully!", HttpStatus.OK);
            } catch (SecurityException e) {
                return new ResponseEntity<>(e.getMessage(), HttpStatus.FORBIDDEN);
            }
        }
    
        // 4. Remove a service
        @DeleteMapping("/{serviceName}")
        public ResponseEntity<String> removeService(@PathVariable String serviceName, @RequestParam String ownerId, 
                                                    @RequestParam String name, @RequestParam String email, 
                                                    @RequestParam String password) {
            SalonOwner owner = new SalonOwner(ownerId, name, email, password);  // Create the SalonOwner object
            try {
                serviceManagementService.removeService(owner, serviceName);
                return new ResponseEntity<>("Service removed successfully!", HttpStatus.OK);
            } catch (SecurityException e) {
                return new ResponseEntity<>(e.getMessage(), HttpStatus.FORBIDDEN);
            }
        }
    
        // 5. Checkout a service (custom business workflow, for instance)
        @PostMapping("/{serviceName}/checkout")
        public ResponseEntity<String> checkoutService(@PathVariable String serviceName, @RequestParam String ownerId, 
                                                      @RequestParam String name, @RequestParam String email, 
                                                      @RequestParam String password) {
            SalonOwner owner = new SalonOwner(ownerId, name, email, password);  // Create the SalonOwner object
            try {
                // Example: business logic for "checking out" a service (you can adjust based on your needs)
                serviceManagementService.removeService(owner, serviceName);  // This could be updated to your checkout logic
                return new ResponseEntity<>("Service checked out successfully!", HttpStatus.OK);
            } catch (SecurityException e) {
                return new ResponseEntity<>(e.getMessage(), HttpStatus.FORBIDDEN);
            }
        }
    }
       

