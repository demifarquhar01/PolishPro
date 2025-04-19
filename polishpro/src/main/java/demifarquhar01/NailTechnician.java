package demifarquhar01;

import java.time.LocalDateTime;
import java.util.List;

public class NailTechnician extends User {
    
    public NailTechnician(String userId, String name, String email, String password) {
        super(userId, name, email, password);
    }

    public void viewSchedule(Schedule schedule) {
        System.out.println("Schedule for technician " + getName() + ":");
        schedule.viewAssignedAppointments();
    }

    public void updateSchedule(Schedule schedule, List<LocalDateTime> newAvailableSlots) {
        System.out.println("Updating schedule for technician " + getName());
        schedule.updateSchedule(newAvailableSlots);  // Passing the new available slots
    }
}



