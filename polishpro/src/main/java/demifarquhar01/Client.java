package demifarquhar01;

import java.time.LocalDateTime;

public class Client extends User {


public Client(String userId, String name, String email, String password) {
        super(userId, name, email, password);
    }

    public void bookAppointment(Appointment appt) {
        if (appt != null) {
            appt.book();
            System.out.println("Appointment booked by client: " + getName());
        } else {
            System.out.println("Cannot book a null appointment.");
        }
    }

    public void cancelAppointment(Appointment appt) {
        if (appt != null) {
            appt.cancel();
            System.out.println("Appointment cancelled by client: " + getName());
        } else {
            System.out.println("Cannot cancel a null appointment.");
        }
    }

    public void rescheduleAppointment(Appointment appt, Reschedule reschedule) {
        if (appt != null && reschedule != null) {
            LocalDateTime newDateTime = reschedule.getNewDateTime(); // Get new date from Reschedule class
            appt.reschedule(newDateTime);
            reschedule.confirmReschedule();
            System.out.println("Appointment rescheduled by client: " + getName());
        } else {
            System.out.println("Invalid reschedule attempt.");
        }
    }
}
