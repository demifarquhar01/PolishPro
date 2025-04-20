package demifarquhar01;


import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import demifarquhar01.creational_pattern.Builder;

public class BuilderTest {

    // ✅ Test: Correct object creation
    @Test
    public void testAppointmentCreation() {
        Builder.Appointment appointment = new Builder.AppointmentBuilder("A001", "2025-04-20 10:00")
                .client("John Doe")
                .technician("Alice")
                .service("Manicure")
                .build();

        assertNotNull(appointment);
        assertTrue(appointment.toString().contains("appointmentId='A001'"));
        assertTrue(appointment.toString().contains("dateTime='2025-04-20 10:00'"));
        assertTrue(appointment.toString().contains("client='John Doe'"));
        assertTrue(appointment.toString().contains("technician='Alice'"));
        assertTrue(appointment.toString().contains("service='Manicure'"));
    }

    // ✅ Test: When optional attributes are missing
    @Test
    public void testAppointmentCreationWithMissingOptionalAttributes() {
        Builder.Appointment appointment = new Builder.AppointmentBuilder("A002", "2025-04-21 14:00").build();

        assertNotNull(appointment);
        assertTrue(appointment.toString().contains("appointmentId='A002'"));
        assertTrue(appointment.toString().contains("dateTime='2025-04-21 14:00'"));
        assertTrue(appointment.toString().contains("client='null'"));
        assertTrue(appointment.toString().contains("technician='null'"));
        assertTrue(appointment.toString().contains("service='null'"));
    }

    // ❌ Edge Case: Null appointment ID (required)
    @Test
    public void shouldThrowExceptionWhenAppointmentIdIsNull() {
        assertThrows(IllegalArgumentException.class, () ->
            new Builder.AppointmentBuilder(null, "2025-04-20 10:00").build()
        );
    }

    // ❌ Edge Case: Null dateTime (required)
    @Test
    public void shouldThrowExceptionWhenDateTimeIsNull() {
        assertThrows(IllegalArgumentException.class, () ->
            new Builder.AppointmentBuilder("A003", null).build()
        );
    }

    // ❌ Edge Case: Invalid date format (if format validation exists)
    @Test
    public void shouldThrowExceptionWhenDateFormatIsInvalid() {
        assertThrows(IllegalArgumentException.class, () ->
            new Builder.AppointmentBuilder("A004", "2025-20-04 10:00").build()
        );
    }
}


