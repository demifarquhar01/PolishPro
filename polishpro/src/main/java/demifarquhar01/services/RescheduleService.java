package demifarquhar01.services;

import java.time.LocalDateTime;

import demifarquhar01.Schedule;


public class RescheduleService {

    // Method to reschedule an appointment for a given schedule
    public boolean reschedule(Schedule schedule, LocalDateTime oldDateTime, LocalDateTime newDateTime, String reason) {
        if (oldDateTime == null || newDateTime == null || reason == null || reason.isEmpty()) {
            System.out.println("Error: Old time, new time, and reason must be provided.");
            return false;
        }

        // Check if the old time exists in the schedule
        if (!schedule.getAvailableSlots().contains(oldDateTime)) {
            System.out.println("Error: Old appointment time not found.");
            return false;
        }

        // Check if the new time is available
        if (schedule.getAvailableSlots().contains(newDateTime)) {
            System.out.println("Error: New time slot is already occupied.");
            return false;
        }

        // Proceed with the reschedule: Remove old time and add new time
        schedule.getAvailableSlots().remove(oldDateTime);
        schedule.getAvailableSlots().add(newDateTime);
        System.out.println("Appointment rescheduled successfully from " + oldDateTime + " to " + newDateTime + " for reason: " + reason);

        // Confirm reschedule action
        confirmReschedule(oldDateTime, newDateTime);

        return true;
    }

    // Confirm reschedule action (logging it)
    private void confirmReschedule(LocalDateTime oldDateTime, LocalDateTime newDateTime) {
        System.out.println("Reschedule confirmed: From " + oldDateTime + " to " + newDateTime);
    }
}


