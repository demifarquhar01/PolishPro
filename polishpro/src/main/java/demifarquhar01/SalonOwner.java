package demifarquhar01;


public class SalonOwner extends User {

    public SalonOwner(String name, String email, String password) {
        super(name, email, password);
    }

    // Method to modify a service
    public void modifyService(Service service, String newName, String newDescription, int newDuration, double newPrice, boolean newStatus) {
        if (service != null) {
            service.modifyService(newName, newDescription, newDuration, newPrice, newStatus);
            System.out.println("Service modified by Salon Owner: " + getName());
        } else {
            System.out.println("Service is null, cannot modify.");
        }
    }
}


