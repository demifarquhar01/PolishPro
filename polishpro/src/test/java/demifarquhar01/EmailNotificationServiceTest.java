package demifarquhar01;



import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import demifarquhar01.repositories.inmemory.InMemoryEmailNotificationRepository;
import demifarquhar01.services.EmailNotificationService;

public class EmailNotificationServiceTest {

    private EmailNotificationService service;
    private InMemoryEmailNotificationRepository repository;

    @BeforeEach
    public void setUp() {
        repository = new InMemoryEmailNotificationRepository();
        service = new EmailNotificationService(repository);
    }

    @Test
    public void testSendAppointmentBookingNotification_success() {
        service.sendAppointmentBookingNotification("client@example.com", "APT-001", "Your appointment is booked.");

        // Ensure notification is saved
        List<EmailNotification> notifications = repository.findAll();
        assertEquals(1, notifications.size());

        // Check the content of the notification
        EmailNotification notification = notifications.get(0);
        assertEquals("Appointment Booked", notification.getSubject());
        assertEquals("Sent", notification.getStatus()); // Status should be "Sent"
    }

    @Test
    public void testSendAppointmentReschedulingNotification_success() {
        service.sendAppointmentReschedulingNotification("client@example.com", "APT-002", "Rescheduled successfully.");

        // Ensure notification is saved
        List<EmailNotification> notifications = repository.findAll();
        assertEquals(1, notifications.size());

        // Check the content of the notification
        EmailNotification notification = notifications.get(0);
        assertEquals("Appointment Rescheduled", notification.getSubject());
        assertEquals("Sent", notification.getStatus()); // Status should be "Sent"
    }

    @Test
    public void testSendAppointmentCancellationNotification_success() {
        service.sendAppointmentCancellationNotification("client@example.com", "APT-003", "Your appointment was cancelled.");

        // Ensure notification is saved
        List<EmailNotification> notifications = repository.findAll();
        assertEquals(1, notifications.size());

        // Check the content of the notification
        EmailNotification notification = notifications.get(0);
        assertEquals("Appointment Cancelled", notification.getSubject());
        assertEquals("Sent", notification.getStatus()); // Status should be "Sent"
    }

    @Test
    public void testNotifyNailTechnicianForClientPreferences_success() {
        service.notifyNailTechnicianForClientPreferences("tech@example.com", "Lisa", "No glitter");

        // Ensure notification is saved
        List<EmailNotification> notifications = repository.findAll();
        assertEquals(1, notifications.size());

        // Check the content of the notification
        EmailNotification notification = notifications.get(0);
        assertEquals("Client Preferences Updated", notification.getSubject());
        assertTrue(notification.getMessage().contains("Lisa"));
        assertEquals("Sent", notification.getStatus()); // Status should be "Sent"
    }

    @Test
    public void testSendNotification_invalidEmail_failsAndEscalates() {
        EmailNotification invalidNotification = new EmailNotification(UUID.randomUUID().toString(), "", "Subject", "Body", "Type");
        service.sendNotification(invalidNotification);

        // Ensure notification is saved
        List<EmailNotification> notifications = repository.findAll();
        assertEquals(1, notifications.size());

        // Check the status of the notification
        EmailNotification notification = notifications.get(0);
        assertEquals("Failed", notification.getStatus()); // Status should be "Failed"
    }

    @Test
    public void testScheduleReminder_invalidEmail_failsAndEscalates() {
        EmailNotification invalidNotification = new EmailNotification(UUID.randomUUID().toString(), null, "Reminder", "Body", "Reminder");
        service.scheduleReminder(invalidNotification);

        // Ensure notification is saved
        List<EmailNotification> notifications = repository.findAll();
        assertEquals(1, notifications.size());

        // Check the status of the notification
        EmailNotification notification = notifications.get(0);
        assertEquals("Failed", notification.getStatus()); // Status should be "Failed"
    }

    @Test
    public void testFindById_success() {
        String notificationId = UUID.randomUUID().toString();
        EmailNotification notification = new EmailNotification(notificationId, "client@example.com", "Subject", "Message", "Reminder");
        repository.save(notification);

        Optional<EmailNotification> foundNotification = repository.findById(notificationId);
        assertTrue(foundNotification.isPresent());
        assertEquals(notificationId, foundNotification.get().getNotificationId());
    }

    @Test
    public void testFindById_notFound() {
        Optional<EmailNotification> foundNotification = repository.findById("nonexistent-id");
        assertFalse(foundNotification.isPresent());
    }

    @Test
    public void testDelete_success() {
        String notificationId = UUID.randomUUID().toString();
        EmailNotification notification = new EmailNotification(notificationId, "client@example.com", "Subject", "Message", "Reminder");
        repository.save(notification);

        repository.delete(notificationId);

        Optional<EmailNotification> foundNotification = repository.findById(notificationId);
        assertFalse(foundNotification.isPresent());
    }

    @Test
    public void testDelete_notFound() {
        repository.delete("nonexistent-id");
        // Ensure no exception or error is thrown and the repository remains intact
        assertEquals(0, repository.findAll().size());
    }
}
