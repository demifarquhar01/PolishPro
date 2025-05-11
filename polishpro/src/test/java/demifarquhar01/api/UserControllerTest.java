package demifarquhar01.api;



    import org.junit.jupiter.api.Disabled;
    import org.junit.jupiter.api.Test;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
    import org.springframework.boot.test.context.SpringBootTest;
    import org.springframework.http.MediaType;
    import org.springframework.test.web.servlet.MockMvc;
    import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
    import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
    import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

    import com.fasterxml.jackson.databind.ObjectMapper;

import demifarquhar01.User;
import demifarquhar01.services.UserService;
   @Disabled 
    @SpringBootTest
    @AutoConfigureMockMvc
    public class UserControllerTest {
    
        @Autowired
        private MockMvc mockMvc;
    
        @Autowired
        private ObjectMapper objectMapper;
    
        @Autowired
        private UserService userService;

    @Disabled
        // Test for user registration with valid data
        @Test
        public void testRegisterUser_ReturnsCreated() throws Exception {
            User user = new User("user01", "John Doe", "johndoe@example.com", "password123");
    
            mockMvc.perform(post("/api/users/register")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(objectMapper.writeValueAsString(user)))
                    .andExpect(status().isCreated())
                    .andExpect(content().string("User registered successfully!"));
        }
    @Disabled
        // Test for user registration with missing User ID
        @Test
        public void testRegisterUser_MissingUserId_ReturnsBadRequest() throws Exception {
            User user = new User("", "John Doe", "johndoe@example.com", "password123");
    
            mockMvc.perform(post("/api/users/register")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(objectMapper.writeValueAsString(user)))
                    .andExpect(status().isBadRequest())
                    .andExpect(content().string("Error: User ID is required."));
        }
    @Disabled
        // Test for user login with valid credentials
        @Test
        public void testLoginUser_ReturnsOk() throws Exception {
            // Ensure user exists first
            User user = new User("user02", "Jane Doe", "janedoe@example.com", "password123");
            userService.registerUser(user.getUserId(), user.getName(), user.getEmail(), user.getPassword());
    
            mockMvc.perform(post("/api/users/login")
                            .param("email", "janedoe@example.com")
                            .param("password", "password123"))
                    .andExpect(status().isOk())
                    .andExpect(content().string("Login successful!"));
        }
    @Disabled
        // Test for user login with invalid credentials
        @Test
        public void testLoginUser_InvalidCredentials_ReturnsUnauthorized() throws Exception {
            mockMvc.perform(post("/api/users/login")
                            .param("email", "invalid@example.com")
                            .param("password", "wrongpassword"))
                    .andExpect(status().isUnauthorized())
                    .andExpect(content().string("Login failed. Invalid credentials."));
        }
    @Disabled
        // Test for user logout with valid userId
        @Test
        public void testLogoutUser_ReturnsOk() throws Exception {
            // Ensure user exists first
            User user = new User("user03", "Mike Smith", "mikesmith@example.com", "password123");
            userService.registerUser(user.getUserId(), user.getName(), user.getEmail(), user.getPassword());
    
            mockMvc.perform(post("/api/users/user03/logout"))
                    .andExpect(status().isOk())
                    .andExpect(content().string("Logout successful!"));
        }
    @Disabled
        // Test for user logout with invalid userId
        @Test
        public void testLogoutUser_InvalidUserId_ReturnsNotFound() throws Exception {
            mockMvc.perform(post("/api/users/invalidUserId/logout"))
                    .andExpect(status().isNotFound())
                    .andExpect(content().string("Error: User not found"));
        }
    @Disabled
        // Test for password reset with valid data
        @Test
        public void testResetPassword_ReturnsOk() throws Exception {
            // Ensure user exists first
            User user = new User("user04", "Sarah Lee", "sarahlee@example.com", "password123");
            userService.registerUser(user.getUserId(), user.getName(), user.getEmail(), user.getPassword());
    
            mockMvc.perform(post("/api/users/user04/reset-password")
                            .param("newPassword", "newPassword123"))
                    .andExpect(status().isOk())
                    .andExpect(content().string("Password reset successful!"));
        }
    @Disabled
        // Test for password reset with missing new password
        @Test
        public void testResetPassword_MissingNewPassword_ReturnsBadRequest() throws Exception {
            mockMvc.perform(post("/api/users/user04/reset-password")
                            .param("newPassword", ""))
                    .andExpect(status().isBadRequest())
                    .andExpect(content().string("Error: New password is required."));
        }
    @Disabled
        // Test for password reset with invalid userId
        @Test
        public void testResetPassword_InvalidUserId_ReturnsNotFound() throws Exception {
            mockMvc.perform(post("/api/users/invalidUserId/reset-password")
                            .param("newPassword", "newPassword123"))
                    .andExpect(status().isNotFound())
                    .andExpect(content().string("Error: User not found"));
        }
    }
      
    

