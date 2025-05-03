package demifarquhar01.api;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import demifarquhar01.EmailNotification;
import demifarquhar01.repositories.EmailNotificationRepository;
import demifarquhar01.services.EmailNotificationService;

@RestController
@RequestMapping("/api/notifications")
public class EmailNotificationController {

    private final EmailNotificationRepository notificationRepo;
    private final EmailNotificationService notificationService;

    public EmailNotificationController(EmailNotificationRepository notificationRepo,
                                       EmailNotificationService notificationService) {
        this.notificationRepo = notificationRepo;
        this.notificationService = notificationService;
    }

    // GET /api/notifications - Fetch all notifications
    @GetMapping
    public List<EmailNotification> getAllNotifications() {
        return notificationRepo.findAll();
    }

    // POST /api/notifications - Create and send a new notification
    @PostMapping
    public String createNotification(@RequestParam String recipientEmail,
                                     @RequestParam String subject,
                                     @RequestParam String message,
                                     @RequestParam String type) {
        String id = UUID.randomUUID().toString();
        EmailNotification notification = new EmailNotification(id, recipientEmail, subject, message, type);
        notificationService.sendNotification(notification);
        return "Notification sent and saved successfully.";
    }

    // PUT /api/notifications/{id} - Update an existing notification (subject and message)
    @PutMapping("/{id}")
    public String updateNotification(@PathVariable String id,
                                     @RequestParam String subject,
                                     @RequestParam String message) {
        Optional<EmailNotification> existing = notificationRepo.findById(id);

        if (existing.isPresent()) {
            EmailNotification notif = existing.get();
            notif.setSubject(subject);
            notif.setMessage(message);
            notif.setStatus("Updated");
            notificationRepo.save(notif); 
            return "Notification updated successfully.";
        } else {
            return "Notification not found.";
        }
    }

    // POST /api/notifications/{id}/send - Re-send a notification (like "checkout" use case)
    @PostMapping("/{id}/send")
    public String resendNotification(@PathVariable String id) {
        Optional<EmailNotification> notificationOpt = notificationRepo.findById(id);

        if (notificationOpt.isPresent()) {
            EmailNotification notification = notificationOpt.get();
            notificationService.sendNotification(notification);
            return "Notification re-sent.";
        } else {
            return "Notification not found.";
        }
    }

    // POST /api/notifications/{id}/remind - Schedule a reminder
    @PostMapping("/{id}/remind")
    public String scheduleReminder(@PathVariable String id) {
        Optional<EmailNotification> notificationOpt = notificationRepo.findById(id);

        if (notificationOpt.isPresent()) {
            EmailNotification notification = notificationOpt.get();
            notificationService.scheduleReminder(notification);
            return "Reminder scheduled.";
        } else {
            return "Notification not found.";
        }
    }
}

