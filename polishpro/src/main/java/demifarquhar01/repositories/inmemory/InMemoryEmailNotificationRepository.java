package demifarquhar01.repositories.inmemory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import demifarquhar01.EmailNotification;
import demifarquhar01.repositories.EmailNotificationRepository;


    
    public class InMemoryEmailNotificationRepository implements EmailNotificationRepository {
        private final Map<String, EmailNotification> notificationStore = new HashMap<>();
    
        @Override
        public void save(EmailNotification emailNotification) {
            notificationStore.put(emailNotification.getNotificationId(), emailNotification);
        }
    
        @Override
        public Optional<EmailNotification> findById(String id) {
            return Optional.ofNullable(notificationStore.get(id));
        }
    
        @Override
        public void delete(String notificationId) {
            notificationStore.remove(notificationId);
        }
    
        @Override
        public List<EmailNotification> findAll() {
            return new ArrayList<>(notificationStore.values());
        }
    }
       

