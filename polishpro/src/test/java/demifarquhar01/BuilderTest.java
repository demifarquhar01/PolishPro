package demifarquhar01;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import demifarquhar01.creational_pattern.Builder.AppointmentBuilder;

public class BuilderTest {
//JUnit 5
    @Test
    public void testValidAppointmentCreation() {
        // Arrange
        String appointmentId = "A001";
        LocalDateTime dateTime = LocalDateTime.of(2025, 4, 20, 10, 0);
        String status = "Booked";

        // Act
        Appointment appointment = new AppointmentBuilder(appointmentId, dateTime)
                .status(status)
                .build();

        // Assert
        assertNotNull(appointment);
        assertEquals(appointmentId, appointment.getAppointmentId());
        assertEquals(dateTime, appointment.getDateTime());
        assertEquals(status, appointment.getStatus());
    }

    @Test
    public void testDefaultStatus() {
        // Arrange
        String appointmentId = "A002";
        LocalDateTime dateTime = LocalDateTime.of(2025, 4, 21, 11, 0);

        // Act
        Appointment appointment = new AppointmentBuilder(appointmentId, dateTime).build();

        // Assert
        assertNotNull(appointment);
        assertEquals("Pending", appointment.getStatus()); // Default status should be "Pending"
    }

    @Test
    public void testInvalidAppointmentId() {
        // Arrange
        String appointmentId = null;
        LocalDateTime dateTime = LocalDateTime.of(2025, 4, 22, 14, 0);

        // Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new AppointmentBuilder(appointmentId, dateTime).build();
        });
        assertEquals("Appointment ID and DateTime cannot be null", exception.getMessage());
    }

    @Test
    public void testInvalidDateTime() {
        // Arrange
        String appointmentId = "A003";
        LocalDateTime dateTime = null;

        // Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new AppointmentBuilder(appointmentId, dateTime).build();
        });
        assertEquals("Appointment ID and DateTime cannot be null", exception.getMessage());
    }

    @Test
    public void testEmptyStatus() {
        // Arrange
        String appointmentId = "A004";
        LocalDateTime dateTime = LocalDateTime.of(2025, 4, 23, 12, 0);
        String status = "";

        // Act
        Appointment appointment = new AppointmentBuilder(appointmentId, dateTime)
                .status(status)
                .build();

        // Assert
        assertNotNull(appointment);
        assertEquals("", appointment.getStatus()); // Empty status should be allowed
    }

    @Test
    public void testBuilderWithNullStatus() {
        // Arrange
        String appointmentId = "A005";
        LocalDateTime dateTime = LocalDateTime.of(2025, 4, 24, 13, 0);

        // Act
        Appointment appointment = new AppointmentBuilder(appointmentId, dateTime)
                .status(null) // Status is null
                .build();

        // Assert
        assertNotNull(appointment);
        assertNull(appointment.getStatus()); // Null status should be allowed
    }
}


