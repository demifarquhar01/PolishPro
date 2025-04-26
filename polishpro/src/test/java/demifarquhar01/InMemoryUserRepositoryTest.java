package demifarquhar01;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import demifarquhar01.repositories.UserRepository;
import demifarquhar01.repositories.inmemory.InMemoryUserRepository;


    
    public class InMemoryUserRepositoryTest {
    
        private UserRepository repository;
    
        @BeforeEach
        public void setUp() {
            repository = new InMemoryUserRepository();
        }
    
        @Test
        public void testSaveUser() {
            User user = new User("1", "Alice", "alice@example.com", "password123");
            repository.save(user);
    
            assertEquals(1, repository.findAll().size(), "Repository should contain 1 user after saving");
        }
    
        @Test
        public void testFindUserById() {
            User user;
            user = new User("2", "Toni", "toni@example.com", "password456");
            repository.save(user);
    
            assertTrue(repository.findById("2").isPresent(), "User should be found by ID");
            assertEquals("Toni", repository.findById("2").get().getName(), "Found user name should match");
        }
    
        @Test
        public void testDeleteUser() {
            User user;
            user = new User("3", "Robyn", "robyn@example.com", "password789");
            repository.save(user);
    
            repository.delete("3");
    
            assertFalse(repository.findById("3").isPresent(), "User should not exist after deletion");
        }
    
        @Test
        public void testFindAllUsers() {
            repository.save(new User("4", "Dana", "dana@example.com", "danaPass"));
            repository.save(new User("5", "Eli", "eli@example.com", "eliPass"));
    
            assertEquals(2, repository.findAll().size(), "Repository should return all saved users");
        }
    
        @Test
        public void testOverwriteUser() {
            User user = new User("6", "Fiona", "fiona@example.com", "fionaPass");
            repository.save(user);
    
            // Overwrite user with the same ID but different details
            User updatedUser = new User("6", "Fiona Updated", "fiona.updated@example.com", "newFionaPass");
            repository.save(updatedUser);
    
            User foundUser = repository.findById("6").get();
            assertEquals("Fiona Updated", foundUser.getName(), "User name should be updated");
            assertEquals("fiona.updated@example.com", foundUser.getEmail(), "User email should be updated");
            assertEquals("newFionaPass", foundUser.getPassword(), "User password should be updated");
        }
    }
    
    

