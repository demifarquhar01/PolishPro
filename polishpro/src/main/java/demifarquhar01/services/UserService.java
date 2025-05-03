package demifarquhar01.services;

import java.util.List;
import java.util.Optional;

import demifarquhar01.User;
import demifarquhar01.repositories.UserRepository;
    
    public class UserService {
        private final UserRepository userRepository;
    
        public UserService(UserRepository userRepository) {
            this.userRepository = userRepository;
        }
    
        // Register a new user
        public void registerUser(String userId, String name, String email, String password) {
            Optional<User> existingUser = userRepository.findById(userId);
            if (existingUser.isPresent()) {
                throw new IllegalArgumentException("User already exists with ID: " + userId);
            }
    
            User newUser = new User(userId, name, email, password);
            userRepository.save(newUser);
            newUser.register();
        }
    
        // Validate login
        public boolean login(String email, String password) {
            List<User> users = userRepository.findAll();
            for (User user : users) {
                if (user.getEmail().equalsIgnoreCase(email) && user.getPassword().equals(password)) {
                    user.login(email, password);
                    return true;
                }
            }
            System.out.println("Login failed.");
            return false;
        }
    
        // Reset password
        public void resetPassword(String userId, String newPassword) {
            User user = userRepository.findById(userId)
                    .orElseThrow(() -> new IllegalArgumentException("User not found: " + userId));
            user.resetPassword(newPassword);
            userRepository.save(user);
        }
    
        // Logout user
        public void logoutUser(String userId) {
            User user = userRepository.findById(userId)
                    .orElseThrow(() -> new IllegalArgumentException("User not found: " + userId));
            user.logout();
        }
    }
       
    
