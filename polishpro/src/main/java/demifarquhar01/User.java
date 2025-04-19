package demifarquhar01;
import java.util.UUID;

public class User {
    private String userId;
    private String name;
    private String email;
    private String password;
    private boolean loggedIn;

    // Constructor
    public User(String name, String email, String password) {
        this.userId = UUID.randomUUID().toString(); // auto-generate ID
        this.name = name;
        this.email = email;
        this.password = password;
        this.loggedIn = false;
    }

    // Getters
    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Method: Register
    public void register() {
        System.out.println("User registered successfully with email: " + email);
        // In a real app, you'd save the user to a database here.
    }

    // Method: Login
    public void login(String inputEmail, String inputPassword) {
        if (this.email.equals(inputEmail) && this.password.equals(inputPassword)) {
            loggedIn = true;
            System.out.println("Login successful. Welcome, " + name + "!");
        } else {
            System.out.println("Login failed. Invalid email or password.");
        }
    }

    // Method: Logout
    public void logout() {
        if (loggedIn) {
            loggedIn = false;
            System.out.println(name + " has logged out.");
        } else {
            System.out.println("User is not logged in.");
        }
    }

    // Method: Reset Password
    public void resetPassword(String newPassword) {
        this.password = newPassword;
        System.out.println("Password has been reset successfully for " + email);
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
