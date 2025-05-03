package demifarquhar01.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import demifarquhar01.User;
import demifarquhar01.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    // Constructor injection for the UserService
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Endpoint to register a new user
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        // Manual validation
        if (user.getUserId() == null || user.getUserId().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: User ID is required.");
        }
        if (user.getName() == null || user.getName().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: Name is required.");
        }
        if (user.getEmail() == null || user.getEmail().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: Email is required.");
        }
        if (user.getPassword() == null || user.getPassword().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: Password is required.");
        }

        try {
            userService.registerUser(user.getUserId(), user.getName(), user.getEmail(), user.getPassword());
            return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully!");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage());
        }
    }

    // Endpoint to log in a user
    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestParam String email, @RequestParam String password) {
        if (email == null || email.isEmpty() || password == null || password.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: Email and password are required.");
        }

        boolean loginSuccessful = userService.login(email, password);
        if (loginSuccessful) {
            return ResponseEntity.ok("Login successful!");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login failed. Invalid credentials.");
        }
    }

    // Endpoint to log out a user
    @PostMapping("/{userId}/logout")
    public ResponseEntity<String> logoutUser(@PathVariable String userId) {
        if (userId == null || userId.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: User ID is required.");
        }
        try {
            userService.logoutUser(userId);
            return ResponseEntity.ok("Logout successful!");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: " + e.getMessage());
        }
    }

    // Endpoint to reset a user's password
    @PostMapping("/{userId}/reset-password")
    public ResponseEntity<String> resetPassword(@PathVariable String userId, @RequestParam String newPassword) {
        if (userId == null || userId.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: User ID is required.");
        }
        if (newPassword == null || newPassword.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: New password is required.");
        }

        try {
            userService.resetPassword(userId, newPassword);
            return ResponseEntity.ok("Password reset successful!");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: " + e.getMessage());
        }
    }
}
