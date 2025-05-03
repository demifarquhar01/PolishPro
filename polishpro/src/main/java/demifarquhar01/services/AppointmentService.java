package demifarquhar01.services;
import java.util.List;

import demifarquhar01.Appointment;
import demifarquhar01.Client;
import demifarquhar01.Reschedule;
import demifarquhar01.Service;
import demifarquhar01.repositories.AppointmentRepository;

public class AppointmentService {

    private final AppointmentRepository appointmentRepository;

    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    /**
     * Validates and books an appointment for a client.
     */
  public boolean bookAppointment(Client client, Appointment appointment, Service service) {
    if (service == null) {
        System.out.println("Booking failed: Appointment must be linked to a service.");
        return false;
    }

    String clientId = client.getUserId();
    List<Appointment> allAppointments = appointmentRepository.findAll();

    boolean hasActiveAppointment = allAppointments.stream()
        .anyMatch(a -> a.getAppointmentId().startsWith(clientId)
                    && !a.getStatus().equalsIgnoreCase("Cancelled"));

    if (hasActiveAppointment) {
        System.out.println("Booking failed: Client already has an active appointment.");
        return false;
    }

    boolean overlaps = allAppointments.stream()
        .anyMatch(a -> a.getDateTime().equals(appointment.getDateTime()) && !a.getStatus().equalsIgnoreCase("Cancelled"));

    if (overlaps) {
        System.out.println("Booking failed: Overlapping appointment exists.");
        return false;
    }

    if (!appointment.getStatus().equalsIgnoreCase("Confirmed")) {
        System.out.println("Booking failed: Appointment must be confirmed before booking.");
        return false;
    }

    client.bookAppointment(appointment);
    appointmentRepository.save(appointment);
    System.out.println("Booking succeeded for service: " + service.getName());
    return true;
}


    /**
     * Cancel an appointment via the Client.
     */
    public void cancelAppointment(Client client, Appointment appointment) {
        // Assuming cancelAppointment method updates some internal state in Client or Appointment
        client.cancelAppointment(appointment);
    
        // Create a new appointment with the status set to "Cancelled"
        Appointment cancelledAppointment = new Appointment(
            appointment.getAppointmentId(),  // Keep the same ID
            appointment.getDateTime(),       // Keep the same date and time
            "Cancelled"                      // Set the status to "Cancelled"
        );
    
        // Save the updated appointment
        appointmentRepository.save(cancelledAppointment);
    }
    
    /**
     * Reschedule an appointment via the Client.
     */
    public void rescheduleAppointment(Client client, Appointment appointment, Reschedule reschedule) {
        client.rescheduleAppointment(appointment, reschedule);
        appointmentRepository.save(appointment);
    }
}
