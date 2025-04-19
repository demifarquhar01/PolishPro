package demifarquhar01.creational_pattern;

public class Prototype {

    public class Service implements Cloneable {
        private String serviceId;
        private String name;
        private String description;
        private double price;
    
        public Service(String serviceId, String name, String description, double price) {
            this.serviceId = serviceId;
            this.name = name;
            this.description = description;
            this.price = price;
        }
    
        @Override
        public Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    
        public String getServiceId() {
            return serviceId;
        }
    
        public String getName() {
            return name;
        }
    
        public String getDescription() {
            return description;
        }
    
        public double getPrice() {
            return price;
        }
    }
        
    
}
