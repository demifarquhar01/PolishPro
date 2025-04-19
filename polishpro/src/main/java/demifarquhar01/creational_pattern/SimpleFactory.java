package demifarquhar01.creational_pattern;

import demifarquhar01.Client;
import demifarquhar01.ITAdministrator;
import demifarquhar01.NailTechnician;
import demifarquhar01.SalonOwner;
import demifarquhar01.User;



public class SimpleFactory {

 // Simple Factory for creating User instances

    public static User createUser(String userType, String userId, String name, String email, String password) {
        if ("Client".equalsIgnoreCase(userType)) {
            return new Client(userId, name, email, password);
        } else if ("NailTechnician".equalsIgnoreCase(userType)) {
            return new NailTechnician(userId, name, email, password);
        } else if ("SalonOwner".equalsIgnoreCase(userType)) {
            return new SalonOwner(userId, name, email, password);
        } else if ("ITAdministrator".equalsIgnoreCase(userType)) {
            return new ITAdministrator(userId, name, email, password);
        }
        return null;
    }
    
}
