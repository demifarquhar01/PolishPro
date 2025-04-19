package demifarquhar01;
import java.time.LocalDateTime;

public class Appointment {
    private final String appointmentId;
    private LocalDateTime dateTime;
    private String status;

    public Appointment(String appointmentId, LocalDateTime dateTime, String status) {
        this.appointmentId = appointmentId;
        this.dateTime = dateTime;
        this.status = status;
    }

    public void book() {
        status = "Booked";
        System.out.println("Appointment " + appointmentId + " booked for " + dateTime);
    }

    public void cancel() {
        status = "Cancelled";
        System.out.println("Appointment " + appointmentId + " has been cancelled.");
    }

    public void reschedule(LocalDateTime newDateTime) {
        this.dateTime = newDateTime;
        status = "Rescheduled";
        System.out.println("Appointment " + appointmentId + " rescheduled to " + newDateTime);
    }

    public void confirm() {
        status = "Confirmed";
        System.out.println("Appointment " + appointmentId + " is confirmed for " + dateTime);
    }

    // Optionally, add getters
    public String getAppointmentId() {
        return appointmentId;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getStatus() {
        return status;
    }
}

  