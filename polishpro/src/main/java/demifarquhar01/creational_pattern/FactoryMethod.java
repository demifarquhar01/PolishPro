package demifarquhar01.creational_pattern;

import demifarquhar01.Service;

public class FactoryMethod {

    // Concrete ManicureService class
    public static class ManicureService extends Service {
        public ManicureService(String name, String description, int duration, double price, boolean status) {
            super(name, description, duration, price, status);
        }

        @Override
        public void modifyService(String newName, String newDescription, int newDuration, double newPrice, boolean newStatus) {
            setName(newName);
            setDescription(newDescription);
            setDuration(newDuration);
            setPrice(newPrice);
            setStatus(newStatus);
            System.out.println("Manicure Service modified: " + newName);
        }
    }

    // Concrete PedicureService class
    public static class PedicureService extends Service {
        public PedicureService(String name, String description, int duration, double price, boolean status) {
            super(name, description, duration, price, status);
        }

        @Override
        public void modifyService(String newName, String newDescription, int newDuration, double newPrice, boolean newStatus) {
            setName(newName);
            setDescription(newDescription);
            setDuration(newDuration);
            setPrice(newPrice);
            setStatus(newStatus);
            System.out.println("Pedicure Service modified: " + newName);
        }
    }

    // Abstract ServiceFactory class
    public static abstract class ServiceFactory {
        public abstract Service createService(String name, String description, int duration, double price, boolean status);
    }

    // Concrete ManicureServiceFactory class
    public static class ManicureServiceFactory extends ServiceFactory {
        @Override
        public Service createService(String name, String description, int duration, double price, boolean status) {
            return new ManicureService(name, description, duration, price, status);
        }
    }

    // Concrete PedicureServiceFactory class
    public static class PedicureServiceFactory extends ServiceFactory {
        @Override
        public Service createService(String name, String description, int duration, double price, boolean status) {
            return new PedicureService(name, description, duration, price, status);
        }
    }
}
