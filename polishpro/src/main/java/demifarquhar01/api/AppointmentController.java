package demifarquhar01.api;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demifarquhar01.Appointment;
import demifarquhar01.Client;
import demifarquhar01.repositories.AppointmentRepository;
import demifarquhar01.services.AppointmentService;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    //private final AppointmentService appointmentService;
    private final AppointmentRepository appointmentRepository;

    public AppointmentController(AppointmentService appointmentService, AppointmentRepository appointmentRepository) {
     //   this.appointmentService = appointmentService;
        this.appointmentRepository = appointmentRepository;
    }

    @GetMapping
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

@PostMapping
public Map<String, Object> bookAppointment(@RequestBody Map<String, Object> requestBody) {
    try {
        // Extract client data from request
        String userId = (String) requestBody.get("userId");
        String name = (String) requestBody.get("name");
        String email = (String) requestBody.get("email");
        String password = (String) requestBody.get("password");



        // Create objects
        Client client = new Client(userId, name, email, password);
       // Service service = new Service(serviceName, serviceDescription, duration, price, isActive);

        // Use current datetime (or extract from request)
        LocalDateTime dateTime = LocalDateTime.now();
        Appointment appointment = new Appointment("appt01", dateTime, "Pending");

        // Book the appointment
        client.bookAppointment(appointment);

        return Map.of(
            "message", "Appointment booked successfully",
            "appointmentId", appointment.getAppointmentId(),
            "status", appointment.getStatus(),
            "dateTime", appointment.getDateTime().toString()
        );
    } catch (Exception e) {
        return Map.of("error", "Invalid request data: " + e.getMessage());
    }
}
    @PutMapping("/{id}")
    public String updateAppointment(@PathVariable String id, @RequestBody Appointment updatedAppointment) {
        Appointment updated = new Appointment(id, updatedAppointment.getDateTime(), updatedAppointment.getStatus());
        appointmentRepository.save(updated);
        return "Appointment updated successfully";
    }
}
