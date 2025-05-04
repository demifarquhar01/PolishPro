package demifarquhar01;


    import java.time.LocalDateTime;
    import java.util.Map;

    import static org.hamcrest.Matchers.containsString;
    import static org.hamcrest.Matchers.emptyOrNullString;
    import static org.hamcrest.Matchers.greaterThanOrEqualTo;
    import static org.hamcrest.Matchers.hasSize;
    import static org.hamcrest.Matchers.is;
    import static org.hamcrest.Matchers.not;
    import org.junit.jupiter.api.Test;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
    import org.springframework.boot.test.context.SpringBootTest;
    import org.springframework.http.MediaType;
    import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;

import demifarquhar01.repositories.AppointmentRepository;
    
    
    @SpringBootTest
    @AutoConfigureMockMvc
    public class AppointmentControllerTest {
    
        @Autowired
        private MockMvc mockMvc;
    
        @Autowired
        private AppointmentRepository appointmentRepository;
    
        @Autowired
        private ObjectMapper objectMapper;
    
        @Test
        public void testGetAllAppointments_ReturnsOk() throws Exception {
            // Ensure at least one appointment exists
            Appointment a = new Appointment("testAppt", LocalDateTime.now(), "Pending");
            appointmentRepository.save(a);
    
            mockMvc.perform(get("/api/appointments"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$", hasSize(greaterThanOrEqualTo(1))))
                    .andExpect(jsonPath("$[0].appointmentId", not(emptyOrNullString())));
        }
    
        @Test
        public void testBookAppointment_ReturnsSuccess() throws Exception {
            Map<String, Object> requestBody = Map.of(
                    "userId", "u123",
                    "name", "Alice",
                    "email", "alice@example.com",
                    "password", "12345678"
            );
    
            mockMvc.perform(post("/api/appointments")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(objectMapper.writeValueAsString(requestBody)))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.message", is("Appointment booked successfully")))
                    .andExpect(jsonPath("$.appointmentId", not(emptyOrNullString())))
                    .andExpect(jsonPath("$.status", is("Pending")));
        }
    
        @Test
        public void testBookAppointment_WithMissingFields_ReturnsError() throws Exception {
            Map<String, Object> requestBody = Map.of(
                    "userId", "u123",
                    "name", "Alice"
            );
    
            mockMvc.perform(post("/api/appointments")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(objectMapper.writeValueAsString(requestBody)))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.error", containsString("Invalid request data")));
        }
    
        @Test
        public void testUpdateAppointment_ReturnsSuccess() throws Exception {
            // Save a test appointment first
            Appointment existing = new Appointment("apptUpdateTest", LocalDateTime.now(), "Pending");
            appointmentRepository.save(existing);
    
            Appointment updated = new Appointment(null, LocalDateTime.now().plusDays(1), "Confirmed");
    
            mockMvc.perform(put("/api/appointments/apptUpdateTest")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(objectMapper.writeValueAsString(updated)))
                    .andExpect(status().isOk())
                    .andExpect(content().string("Appointment updated successfully"));
        }
    }
      
    

