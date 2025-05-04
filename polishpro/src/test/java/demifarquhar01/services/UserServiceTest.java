package demifarquhar01.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import demifarquhar01.User;
import demifarquhar01.repositories.UserRepository;
import demifarquhar01.repositories.inmemory.InMemoryUserRepository;

public class UserServiceTest {

    private UserService userService;
    private UserRepository userRepository;
    private List<User> users;

    @BeforeEach
    public void setUp() {
        // Initialize in-memory repository
        users = new ArrayList<>();
        userRepository = new InMemoryUserRepository();
        userService = new UserService(userRepository);

        // Create and save some users for testing
        users.add(new User("3", "Client User", "client@example.com", "password123"));
        users.add(new User("2", "Nail Technician", "technician@example.com", "password123"));
        users.add(new User("1", "Salon Owner", "owner@example.com", "password123"));
        users.add(new User("4", "IT Administrator", "admin@example.com", "adminpassword"));

        // Save users to repository
        userRepository.save(users.get(0));
        userRepository.save(users.get(1));
        userRepository.save(users.get(2));
        userRepository.save(users.get(3));
    }

    // Test case for user registration
    @Test
    public void testRegisterUser_success() {
        // Register a new user
        userService.registerUser("5", "New User", "newuser@example.com", "newpassword123");

        Optional<User> newUser = userRepository.findById("5");
        assertTrue(newUser.isPresent());
        assertEquals("New User", newUser.get().getName());
    }

    // Test case for user registration when user already exists
    @Test
    public void testRegisterUser_existingUserId() {
        // Attempt to register a user with an existing userId
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            userService.registerUser("1", "Duplicate User", "duplicate@example.com", "password123");
        });

        assertEquals("User already exists with ID: 1", exception.getMessage());
    }

    // Test case for successful login
    @Test
    public void testLogin_success() {
        // Test login with correct credentials
        boolean loginResult = userService.login("client@example.com", "password123");
        assertTrue(loginResult);
    }

    // Test case for login failure due to incorrect password
    @Test
    public void testLogin_failure_wrongPassword() {
        // Test login with incorrect password
        boolean loginResult = userService.login("client@example.com", "wrongpassword");
        assertFalse(loginResult);
    }

    // Test case for login failure due to non-existent user
    @Test
    public void testLogin_failure_nonExistentUser() {
        // Test login with non-existent user
        boolean loginResult = userService.login("nonexistent@example.com", "password123");
        assertFalse(loginResult);
    }

    // Test case for resetting password
    @Test
    public void testResetPassword_success() {
        // Reset password for an existing user
        userService.resetPassword("1", "newpassword123");

        Optional<User> user = userRepository.findById("1");
        assertTrue(user.isPresent());
        assertEquals("newpassword123", user.get().getPassword());
    }

    // Test case for resetting password for a non-existent user
    @Test
    public void testResetPassword_userNotFound() {
        // Attempt to reset password for a non-existent user
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            userService.resetPassword("999", "newpassword123");
        });

        assertEquals("User not found: 999", exception.getMessage());
    }

    // Test case for logging out
    @Test
    public void testLogoutUser_success() {
        // Log out an existing user
        userService.logoutUser("1");

        Optional<User> user = userRepository.findById("1");
        assertTrue(user.isPresent());
    }

    // Test case for logging out a non-existent user
    @Test
    public void testLogoutUser_userNotFound() {
        // Attempt to log out a non-existent user
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            userService.logoutUser("999");
        });

        assertEquals("User not found: 999", exception.getMessage());
    }
}


