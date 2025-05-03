package demifarquhar01.services;

import java.util.UUID;

import demifarquhar01.EmailNotification;
import demifarquhar01.repositories.EmailNotificationRepository;

    
    public class EmailNotificationService {
    
        private final EmailNotificationRepository emailNotificationRepository;
    
        public EmailNotificationService(EmailNotificationRepository emailNotificationRepository) {
            this.emailNotificationRepository = emailNotificationRepository;
        }
    
        // Method to send notification
        public void sendNotification(EmailNotification notification) {
            try {
                notification.sendNotification();
                // Save the notification to the repository after sending
                emailNotificationRepository.save(notification);
            } catch (Exception e) {
                // Handle failure (IT Administrator intervention required)
                handleFailure(notification);
            }
        }
    
        // Method to schedule a reminder
        public void scheduleReminder(EmailNotification notification) {
            try {
                notification.scheduleReminder();
                // Save the reminder notification to the repository
                emailNotificationRepository.save(notification);
            } catch (Exception e) {
                // Handle failure (IT Administrator intervention required)
                handleFailure(notification);
            }
        }
    
        // Method to handle notification failures
        private void handleFailure(EmailNotification notification) {
            // Log the failure and update the status
            notification.handleFailure();
    
            // You can implement further escalation, for example, logging the failure to a system or notifying an IT administrator
            // For example, we could log to a failure log or send an alert to the IT Admin
            System.out.println("Escalating failure for notification: " + notification.getNotificationId());
    
            // Simulating IT Administrator notification
            escalateToITAdmin(notification);
        }
    
        // Method to escalate unresolved issues to IT Administrator
        private void escalateToITAdmin(EmailNotification notification) {
            // Log or notify the IT Administrator
            System.out.println("Escalating issue to IT Administrator: Email notification failed for notification ID: " + notification.getNotificationId());
            
            // Here, you can add code to trigger an alert or send a message to the IT Admin about the failure
        }
    
        // Method to create and send a notification for booking an appointment
        public void sendAppointmentBookingNotification(String clientEmail, String appointmentId, String message) {
            String notificationId = UUID.randomUUID().toString();
            EmailNotification notification = new EmailNotification(
                notificationId,
                clientEmail,
                "Appointment Booked",
                message,
                "Booking"
            );
            sendNotification(notification);
        }
    
        // Method to create and send a notification for rescheduling an appointment
        public void sendAppointmentReschedulingNotification(String clientEmail, String appointmentId, String message) {
            String notificationId = UUID.randomUUID().toString();
            EmailNotification notification = new EmailNotification(
                notificationId,
                clientEmail,
                "Appointment Rescheduled",
                message,
                "Rescheduling"
            );
            sendNotification(notification);
        }
    
        // Method to create and send a notification for cancelling an appointment
        public void sendAppointmentCancellationNotification(String clientEmail, String appointmentId, String message) {
            String notificationId = UUID.randomUUID().toString();
            EmailNotification notification = new EmailNotification(
                notificationId,
                clientEmail,
                "Appointment Cancelled",
                message,
                "Cancellation"
            );
            sendNotification(notification);
        }
    
        // Method to notify nail technician when client preferences are updated
        public void notifyNailTechnicianForClientPreferences(String nailTechnicianEmail, String clientName, String preferences) {
            String notificationId = UUID.randomUUID().toString();
            String message = "Client preferences for " + clientName + " have been updated: " + preferences;
            EmailNotification notification = new EmailNotification(
                notificationId,
                nailTechnicianEmail,
                "Client Preferences Updated",
                message,
                "Preferences Update"
            );
            sendNotification(notification);
        }
    }
      