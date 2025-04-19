package demifarquhar01;

public class Service {
    private String name;
    private String description;
    private int duration; // Duration in minutes
    private double price;
    private boolean status; // Active or inactive status

    // Constructor to initialize the service details
    public Service(String name, String description, int duration, double price, boolean status) {
        this.name = name;
        this.description = description;
        this.duration = duration;
        this.price = price;
        this.status = status;
    }

    // Method to modify the service details
    public void modifyService(String newName, String newDescription, int newDuration, double newPrice, boolean newStatus) {
        this.name = newName;
        this.description = newDescription;
        this.duration = newDuration;
        this.price = newPrice;
        this.status = newStatus;

        System.out.println("Service modified: " + newName);
    }

    // Getters for the service attributes (optional)
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getDuration() {
        return duration;
    }

    public double getPrice() {
        return price;
    }

    public boolean isStatus() {
        return status;
    }

 // Add these in your Service class
public void setName(String name) {
    this.name = name;
}

public void setDescription(String description) {
    this.description = description;
}

public void setDuration(int duration) {
    this.duration = duration;
}

public void setPrice(double price) {
    this.price = price;
}

public void setStatus(boolean status) {
    this.status = status;
}   
}

