package demifarquhar01;

import java.time.LocalDateTime;
import java.util.List;

public class Schedule {
    private String scheduleId;
    private List<LocalDateTime> availableSlots;

    // Constructor to initialize the schedule with a scheduleId and available slots
    public Schedule(String scheduleId, List<LocalDateTime> availableSlots) {
        this.scheduleId = scheduleId;
        this.availableSlots = availableSlots;
    }

    // Method to update the schedule with new available slots
    public void updateSchedule(List<LocalDateTime> newAvailableSlots) {
        this.availableSlots = newAvailableSlots;
        System.out.println("Schedule updated for ID: " + scheduleId);
        System.out.println("New available slots: " + availableSlots);
    }

    // Method to view the assigned appointments for this schedule
    public void viewAssignedAppointments() {
        System.out.println("Viewing appointments for schedule ID: " + scheduleId);
        // Example of viewing the available slots or appointments associated with the schedule
        if (availableSlots != null && !availableSlots.isEmpty()) {
            for (LocalDateTime slot : availableSlots) {
                System.out.println("Available slot: " + slot);
            }
        } else {
            System.out.println("No available slots assigned.");
        }
    }

    // Getter and Setter methods for the fields
    public String getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(String scheduleId) {
        this.scheduleId = scheduleId;
    }

    public List<LocalDateTime> getAvailableSlots() {
        return availableSlots;
    }

    public void setAvailableSlots(List<LocalDateTime> availableSlots) {
        this.availableSlots = availableSlots;
    }
}

