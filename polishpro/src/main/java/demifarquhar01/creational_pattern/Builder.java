package demifarquhar01.creational_pattern;
import java.time.LocalDateTime;

import demifarquhar01.Appointment;

public class Builder {

    // Make AppointmentBuilder static
    public static class AppointmentBuilder {
        private final String appointmentId;
        private final LocalDateTime dateTime;
        private String status;

        public AppointmentBuilder(String appointmentId, LocalDateTime dateTime) {
            if (appointmentId == null || dateTime == null) {
                throw new IllegalArgumentException("Appointment ID and DateTime cannot be null");
            }
            this.appointmentId = appointmentId;
            this.dateTime = dateTime;
            this.status = "Pending"; // Default status
        }

        public AppointmentBuilder status(String status) {
            this.status = status; // Allow setting a custom status
            return this;
        }

        public Appointment build() {
            return new Appointment(appointmentId, dateTime, status);
        }
    }
}

