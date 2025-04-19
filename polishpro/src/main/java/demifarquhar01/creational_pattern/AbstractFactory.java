package demifarquhar01.creational_pattern;
import demifarquhar01.Client;
import demifarquhar01.ITAdministrator;
import demifarquhar01.NailTechnician;
import demifarquhar01.SalonOwner;
import demifarquhar01.User;


    public class AbstractFactory {
    
      
        public static abstract class UserFactory {
            public abstract User createClient(String userId, String name, String email, String password);
            public abstract User createNailTechnician(String userId, String name, String email, String password);
            public abstract User createSalonOwner(String userId, String name, String email, String password);
            public abstract User createITAdministrator(String userId, String name, String email, String password);
        }
    
       
        public static class ConcreteUserFactory extends UserFactory {
            @Override
            public User createClient(String userId, String name, String email, String password) {
                return new Client(userId, name, email, password);
            }
    
            @Override
            public User createNailTechnician(String userId, String name, String email, String password) {
                return new NailTechnician(userId, name, email, password);
            }
    
            @Override
            public User createSalonOwner(String userId, String name, String email, String password) {
                return new SalonOwner(userId, name, email, password);
            }
    
            @Override
            public User createITAdministrator(String userId, String name, String email, String password) {
                return new ITAdministrator(userId, name, email, password);
            }
        }
    }
       
    