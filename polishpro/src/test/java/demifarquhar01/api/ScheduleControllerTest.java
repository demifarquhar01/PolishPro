package demifarquhar01.api;

import java.time.LocalDateTime;
import java.util.List;

import static org.hamcrest.Matchers.emptyOrNullString;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.not;
import org.junit.jupiter.api.Disabled;
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

import demifarquhar01.Schedule;
import demifarquhar01.services.ScheduleService;
@Disabled
@SpringBootTest
@AutoConfigureMockMvc
public class ScheduleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ScheduleService scheduleService;

@Disabled
    @Test
    public void testGetAllSchedules_ReturnsOk() throws Exception {
        // Save some sample schedules for testing
        Schedule schedule1 = new Schedule("sched01", List.of(LocalDateTime.now(), LocalDateTime.now().plusHours(1)));
        Schedule schedule2 = new Schedule("sched02", List.of(LocalDateTime.now().plusHours(1), LocalDateTime.now().plusHours(2)));
        scheduleService.addSchedule(null, schedule1);  // Assuming null as technician for simplicity
        scheduleService.addSchedule(null, schedule2);

        mockMvc.perform(get("/api/schedules"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(greaterThanOrEqualTo(2))))
                .andExpect(jsonPath("$[0].scheduleId", not(emptyOrNullString())));
    }

@Disabled
    @Test
    public void testCreateSchedule_ReturnsCreated() throws Exception {
        List<LocalDateTime> availableSlots = List.of(LocalDateTime.now(), LocalDateTime.now().plusHours(1));
        Schedule schedule = new Schedule("sched03", availableSlots);

        mockMvc.perform(post("/api/schedules?technicianId=tech01")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(schedule)))
                .andExpect(status().isCreated())
                .andExpect(content().string("Schedule created successfully!"));
    }

@Disabled
    @Test
    public void testCreateSchedule_WithInvalidTechnician_ReturnsForbidden() throws Exception {
        List<LocalDateTime> availableSlots = List.of(LocalDateTime.now(), LocalDateTime.now().plusHours(1));
        Schedule schedule = new Schedule("sched04", availableSlots);

        mockMvc.perform(post("/api/schedules?technicianId=invalidId")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(schedule)))
                .andExpect(status().isForbidden())
                .andExpect(content().string("Error: Access is denied"));
    }
@Disabled
    @Test
    public void testUpdateSchedule_ReturnsOk() throws Exception {
        // Create a schedule first
        List<LocalDateTime> initialSlots = List.of(LocalDateTime.now(), LocalDateTime.now().plusHours(1));
        Schedule schedule = new Schedule("sched05", initialSlots);
        scheduleService.addSchedule(null, schedule);  // Assuming null as technician for simplicity

        // Update the schedule with new slots
        List<LocalDateTime> newSlots = List.of(LocalDateTime.now().plusDays(1), LocalDateTime.now().plusDays(1).plusHours(1));

        mockMvc.perform(put("/api/schedules/sched05?technicianId=tech01")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(newSlots)))
                .andExpect(status().isOk())
                .andExpect(content().string("Schedule updated successfully!"));
    }
@Disabled
    @Test
    public void testUpdateSchedule_WithInvalidSchedule_ReturnsBadRequest() throws Exception {
        List<LocalDateTime> newSlots = List.of(LocalDateTime.now().plusDays(1));

        mockMvc.perform(put("/api/schedules/nonexistentSched?technicianId=tech01")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(newSlots)))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Error: Invalid schedule ID"));
    }
@Disabled
    @Test
    public void testCheckoutSchedule_ReturnsOk() throws Exception {
        // Create a schedule first
        List<LocalDateTime> availableSlots = List.of(LocalDateTime.now(), LocalDateTime.now().plusHours(1));
        Schedule schedule = new Schedule("sched06", availableSlots);
        scheduleService.addSchedule(null, schedule);  // Assuming null as technician for simplicity

        mockMvc.perform(post("/api/schedules/sched06/checkout?technicianId=tech01"))
                .andExpect(status().isOk())
                .andExpect(content().string("Schedule checked out successfully!"));
    }
@Disabled
    @Test
    public void testCheckoutSchedule_WithInvalidSchedule_ReturnsBadRequest() throws Exception {
        mockMvc.perform(post("/api/schedules/nonexistentSched/checkout?technicianId=tech01"))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Error: Invalid schedule ID"));
    }
}
