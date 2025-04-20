package demifarquhar01.creational_pattern;
import java.time.LocalDateTime;

import demifarquhar01.Appointment;

public class Builder {
    
    // Static inner Builder class
    public static class AppointmentBuilder {
        private String appointmentId;
        private LocalDateTime dateTime;
        private String status = "Pending"; // Default status is "Pending"

        // Constructor for required fields
        public AppointmentBuilder(String appointmentId, LocalDateTime dateTime) {
            if (appointmentId == null || dateTime == null) {
                throw new IllegalArgumentException("Appointment ID and DateTime cannot be null");
            }
            this.appointmentId = appointmentId;
            this.dateTime = dateTime;
        }

        // Setter for the optional status field
        public AppointmentBuilder status(String status) {
            if (status != null && !status.isEmpty()) {
                this.status = status;
            }
            return this;
        }

        // Build method to create the Appointment object
        public Appointment build() {
            return new Appointment(appointmentId, dateTime, status);
        }
    }
}

        