package demifarquhar01;
import static org.junit.Assert.assertNotNull;
 import static org.junit.Assert.assertTrue;
import org.junit.Test;

import demifarquhar01.creational_pattern.Builder;
    
    public class BuilderTest {
    
        // Test: Correct object creation
        @Test
        public void testAppointmentCreation() {
            // Using the builder to create an Appointment object with all details
            Builder.Appointment appointment = new Builder.AppointmentBuilder("A001", "2025-04-20 10:00")
                    .client("John Doe")
                    .technician("Alice")
                    .service("Manicure")
                    .build();
    
            // Assert that the appointment details are initialized correctly
            assertNotNull(appointment);
            assertTrue(appointment.toString().contains("appointmentId='A001'"));
            assertTrue(appointment.toString().contains("dateTime='2025-04-20 10:00'"));
            assertTrue(appointment.toString().contains("client='John Doe'"));
            assertTrue(appointment.toString().contains("technician='Alice'"));
            assertTrue(appointment.toString().contains("service='Manicure'"));
        }
    
        // Test: When optional attributes are missing
        @Test
        public void testAppointmentCreationWithMissingOptionalAttributes() {
            // Using the builder to create an Appointment object with only required fields
            Builder.Appointment appointment = new Builder.AppointmentBuilder("A002", "2025-04-21 14:00")
                    .build(); // No optional fields set
    
            // Assert that the appointment details are initialized correctly with defaults for optional fields
            assertNotNull(appointment);
            assertTrue(appointment.toString().contains("appointmentId='A002'"));
            assertTrue(appointment.toString().contains("dateTime='2025-04-21 14:00'"));
            assertTrue(appointment.toString().contains("client='null'"));
            assertTrue(appointment.toString().contains("technician='null'"));
            assertTrue(appointment.toString().contains("service='null'"));
        }
    
            // ❌ Edge Case: Null appointment ID (required)
    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenAppointmentIdIsNull() {
        new Builder.AppointmentBuilder(null, "2025-04-20 10:00").build();
        }
    
         // ❌ Edge Case: Null dateTime (required)
    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenDateTimeIsNull() {
        new Builder.AppointmentBuilder("A003", null).build();
        }
    
       // ❌ Edge Case: Invalid date format
    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenDateFormatIsInvalid() {
        // Assuming your builder validates the format; otherwise, remove this test
        new Builder.AppointmentBuilder("A004", "2025-20-04 10:00").build();
    }
    }
      

