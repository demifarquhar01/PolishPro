package demifarquhar01.services;


import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import demifarquhar01.Appointment;
import demifarquhar01.Client;
import demifarquhar01.Service;
import demifarquhar01.repositories.AppointmentRepository;
import demifarquhar01.repositories.inmemory.InMemoryAppointmentRepository;

public class AppointmentServiceTest {

    private AppointmentService appointmentService;
    private AppointmentRepository appointmentRepository;
    private Client client;

    @BeforeEach
    public void setUp() {
        // Initialize the in-memory appointment repository
        appointmentRepository = new InMemoryAppointmentRepository();
        
        // Create a sample client
        client = new Client("client123", "John Doe", "john.doe@example.com", "password123");

        // Create the AppointmentService with the repository
        appointmentService = new AppointmentService(appointmentRepository);
    }

    // Test for "An appointment must be linked to one service"
    @Test
    public void testBookingFailsIfServiceIsNull() {
        // Create an appointment with status "Confirmed"
        Appointment appointment = new Appointment("client123-001", LocalDateTime.now().plusDays(1), "Confirmed");
    
        // Try to book the appointment with a null service (this should fail)
        boolean result = appointmentService.bookAppointment(client, appointment, null);
    
        // Assert that the booking fails because the service is null
        assertFalse(result, "Booking should fail if the appointment is not linked to a service.");
    }
    

    // Test for "An appointment cannot overlap with another appointment for the same client"
    @Test
    public void testBookingFailsIfAppointmentOverlaps() {
        // Create a service
        Service service = new Service("Manicure", "Nail polish and care", 30, 25.00, true);

        // Create an existing appointment
        Appointment existingAppointment = new Appointment("client123-002", LocalDateTime.of(2025, 5, 4, 10, 0), "Confirmed");

        // Save the existing appointment in the repository
        appointmentRepository.save(existingAppointment);

        // Create a new appointment that overlaps with the existing one
        Appointment newAppointment = new Appointment("client123-003", LocalDateTime.of(2025, 5, 4, 10, 0), "Confirmed");

        // Try to book the new appointment
        boolean result = appointmentService.bookAppointment(client, newAppointment, service);

        // Assert that the booking fails due to the overlap
        assertFalse(result, "Booking should fail when the appointment overlaps with an existing one.");
    }

    // Test for "Appointment status must be confirmed before being scheduled"
    @Test
    public void testBookingFailsIfStatusNotConfirmed() {
        // Create a service (needed as part of the booking process)
        Service service = new Service("Pedicure", "Foot care", 45, 40.00, true);
    
        // Create an appointment with status "Pending"
        Appointment appointment = new Appointment("client123-004", LocalDateTime.now().plusDays(1), "Pending");
    
        // Try to book the appointment with "Pending" status (this should fail)
        boolean result = appointmentService.bookAppointment(client, appointment, service);
    
        // Assert that the booking fails because the status is not confirmed
        assertFalse(result, "Booking should fail if the appointment status is not 'Confirmed'.");
    }
    

    // Test for successful booking when all validations pass
    @Test
    public void testBookingSucceedsWithValidData() {
        // Create a service
        Service service = new Service("Pedicure", "Foot care", 45, 40.00, true);

        // Create a valid appointment with "Confirmed" status
        Appointment appointment = new Appointment("client123-005", LocalDateTime.now().plusDays(2), "Confirmed");

        // Try to book the appointment with the valid data
        boolean result = appointmentService.bookAppointment(client, appointment, service);

        // Assert that the booking succeeds
        assertTrue(result, "Booking should succeed with valid data.");
    }
}
