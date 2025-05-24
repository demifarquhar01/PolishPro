package demifarquhar01;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDateTime;

import demifarquhar01.Appointment;
import demifarquhar01.creational_pattern.Builder;

public class AppointmentTest {

    @Test
    public void testValidAppointmentCreation() {
        // Arrange
        String appointmentId = "B001";
        LocalDateTime dateTime = LocalDateTime.of(2025, 7, 10, 14, 0);
        String status = "Booked";

        // Act - Creates appointment
        Appointment appointment = new Appointment(appointmentId, dateTime, status);

        // Assert
        assertNotNull(appointment);
        assertEquals(appointmentId, appointment.getAppointmentId());
        assertEquals(dateTime, appointment.getDateTime());
        assertEquals(status, appointment.getStatus());
    }

    @Test
    public void testBook(){
        // Arrange
        String appointmentId = "B002";
        LocalDateTime dateTime = LocalDateTime.of(2025, 4, 20, 10, 0);

        Appointment appointment = new Builder.AppointmentBuilder(appointmentId, dateTime)
                .status("")
                .build();

        // Capture System.out
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Act - Schedules appointment
        appointment.book();

        // Assert
        String expectedOutput = "Appointment B002 booked for 2025-04-20T10:00\n";
        assertEquals(expectedOutput, outContent.toString());
        assertEquals("Booked", appointment.getStatus());

        // Reset System.out
        System.setOut(System.out);
    }

    @Test
    public void testCancel(){
        // Arrange
        String appointmentId = "B003";
        LocalDateTime dateTime = LocalDateTime.of(2025, 8, 27, 12, 0);

        Appointment appointment = new Builder.AppointmentBuilder(appointmentId, dateTime)
                .status("Booked")
                .build();

        // Capture System.out
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Act - Cancels appointment
        appointment.cancel();

        // Assert
        String expectedOutput = "Appointment B003 has been cancelled.\n";
        assertEquals(expectedOutput, outContent.toString());
        assertEquals("Cancelled", appointment.getStatus());

        // Reset System.out
        System.setOut(System.out);
    }

    @Test
    public void testReschedule(){
        // Arrange
        String appointmentId = "B004";
        LocalDateTime dateTime = LocalDateTime.of(2025, 4, 20, 10, 0);
        LocalDateTime newDateTime = LocalDateTime.of(2025, 4, 21, 11, 0);

        Appointment appointment = new Builder.AppointmentBuilder(appointmentId, dateTime)
                .status("Booked")
                .build();

        // Capture System.out
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Act - Reschedules appointment
        appointment.reschedule(newDateTime);

        // Assert
        String expectedOutput = "Appointment B004 rescheduled to 2025-04-21T11:00\n";
        assertEquals(expectedOutput, outContent.toString());
        assertEquals("Rescheduled", appointment.getStatus());
        assertEquals(newDateTime, appointment.getDateTime());

        // Reset System.out
        System.setOut(System.out);
    }

    @Test
    public void testConfirm(){
        // Arrange
        String appointmentId = "B005";
        LocalDateTime dateTime = LocalDateTime.of(2025, 10, 5, 8, 30);

        Appointment appointment = new Builder.AppointmentBuilder(appointmentId, dateTime)
                .status("Booked")
                .build();

        // Capture System.out
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Act - Confirms appointment
        appointment.confirm();

        // Assert
        String expectedOutput = "Appointment B005 is confirmed for 2025-10-05T08:30\n";
        assertEquals(expectedOutput, outContent.toString());
        assertEquals("Confirmed", appointment.getStatus());

        // Reset System.out
        System.setOut(System.out);
    }

    @Test
    public void testNullAppointmentId() {
        // Arrange
        LocalDateTime dateTime = LocalDateTime.of(2025, 6, 15, 9, 0);

        // Act & Assert
        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Appointment(null, dateTime, "")
        );
        assertEquals("Appointment ID and DateTime cannot be null", exception.getMessage());
    }

    @Test
    public void testNullDateTime() {
        // Arrange
        String appointmentId = "B007";

        // Act & Assert
        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Appointment(appointmentId, null, "")
        );
        assertEquals("Appointment ID and DateTime cannot be null", exception.getMessage());
    }

    @Test
    public void testNullStatusAllowed() {
        // Arrange
        String appointmentId = "B008";
        LocalDateTime dateTime = LocalDateTime.of(2025, 11, 1, 15, 0);

        // Act
        Appointment appointment = new Appointment(appointmentId, dateTime, null);

        // Assert
        assertNotNull(appointment);
        assertEquals(appointmentId, appointment.getAppointmentId());
        assertEquals(dateTime, appointment.getDateTime());
        assertNull(appointment.getStatus()); // Verify that status is null
    }
}
