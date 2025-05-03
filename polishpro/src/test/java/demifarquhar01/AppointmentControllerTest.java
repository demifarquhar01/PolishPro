package demifarquhar01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import static org.mockito.Mockito.doNothing;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import demifarquhar01.api.AppointmentController;
import demifarquhar01.repositories.AppointmentRepository;

@SpringBootTest
public class AppointmentControllerTest {

    @MockBean
    private AppointmentRepository appointmentRepository;

    @InjectMocks
    private AppointmentController appointmentController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(appointmentController).build();
    }

    @Test
    public void testBookAppointment() throws Exception {
        // Arrange: Mock behavior for void method
        Appointment appointment = new Appointment("appt01", null, "Pending");

        // If you're mocking a void method that should do nothing
        doNothing().when(appointmentRepository).save(Mockito.any(Appointment.class)); 

        // Act: Perform the POST request
        mockMvc.perform(post("/api/appointments")
                .contentType("application/json")
                .content("{\"userId\":\"user01\",\"name\":\"John Doe\",\"email\":\"john.doe@example.com\",\"password\":\"password123\"}"))
                
                // Assert: Verify that the response status is OK
                .andExpect(status().isOk());
    }
}
