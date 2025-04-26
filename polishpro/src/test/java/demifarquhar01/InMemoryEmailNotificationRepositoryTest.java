package demifarquhar01;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import demifarquhar01.repositories.EmailNotificationRepository;
import demifarquhar01.repositories.inmemory.InMemoryEmailNotificationRepository;


 
 public class InMemoryEmailNotificationRepositoryTest {
 
     private EmailNotificationRepository repo;
 
     @BeforeEach
     public void setup() {
         repo = new InMemoryEmailNotificationRepository();
     }
 
     @Test
     public void testSaveEmailNotification() {
         EmailNotification notification = new EmailNotification("notif1", "test@example.com", "Welcome", "Hello there!", "General");
         repo.save(notification);
 
         assertEquals(1, repo.findAll().size(), "Repository should contain 1 email notification after saving");
     }
 
     @Test
     public void testFindByIdEmailNotification() {
         EmailNotification notification = new EmailNotification("notif2", "user@example.com", "Appointment Reminder", "Don't forget your appointment!", "Reminder");
         repo.save(notification);
 
         Optional<EmailNotification> found = repo.findById("notif2");
 
         assertTrue(found.isPresent(), "EmailNotification should be found by ID");
         assertEquals("notif2", found.get().getNotificationId(), "Found EmailNotification ID should match");
     }
 
     @Test
     public void testDeleteEmailNotification() {
         EmailNotification notification = new EmailNotification("notif3", "another@example.com", "Promotion", "Check our new services!", "Promotion");
         repo.save(notification);
 
         repo.delete("notif3");
 
         assertFalse(repo.findById("notif3").isPresent(), "EmailNotification should not exist after deletion");
     }
 
     @Test
     public void testFindAllEmailNotifications() {
         repo.save(new EmailNotification("notif4", "client1@example.com", "Reminder 1", "Your appointment is coming up!", "Reminder"));
         repo.save(new EmailNotification("notif5", "client2@example.com", "Reminder 2", "Don't miss your appointment!", "Reminder"));
 
         assertEquals(2, repo.findAll().size(), "Repository should return all saved email notifications");
     }
 }
    
    
