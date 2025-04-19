package demifarquhar01;

public class EmailNotification {
    private String notificationId;
    private String recipientEmail;
    private String subject;
    private String message;
    private String status;
    private String type;

    // Constructor to initialize the EmailNotification object
    public EmailNotification(String notificationId, String recipientEmail, String subject, String message, String type) {
        this.notificationId = notificationId;
        this.recipientEmail = recipientEmail;
        this.subject = subject;
        this.message = message;
        this.status = "Pending";  // Default status is "Pending"
        this.type = type;
    }

    // Method to send the email notification
    public void sendNotification() {
        if (recipientEmail != null && !recipientEmail.isEmpty()) {
            this.status = "Sent";
            System.out.println("Email sent to: " + recipientEmail);
            System.out.println("Subject: " + subject);
            System.out.println("Message: " + message);
        } else {
            handleFailure();
            System.out.println("Failed to send email. No recipient specified.");
        }
    }

    // Method to schedule a reminder for a future notification
    public void scheduleReminder() {
        if (recipientEmail != null && !recipientEmail.isEmpty()) {
            this.status = "Scheduled";
            System.out.println("Reminder scheduled for: " + recipientEmail);
            System.out.println("Subject: " + subject);
        } else {
            handleFailure();
            System.out.println("Failed to schedule reminder. No recipient specified.");
        }
    }

    // Method to handle failure by updating the status
    public void handleFailure() {
        this.status = "Failed";
        System.out.println("Notification failed. Status set to 'Failed'.");
    }

    // Getter and Setter methods for the fields
    public String getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(String notificationId) {
        this.notificationId = notificationId;
    }

    public String getRecipientEmail() {
        return recipientEmail;
    }

    public void setRecipientEmail(String recipientEmail) {
        this.recipientEmail = recipientEmail;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
