package demifarquhar01;



    import java.time.LocalDateTime;

    import static org.junit.jupiter.api.Assertions.assertEquals;
    import static org.junit.jupiter.api.Assertions.assertNotNull;
    import static org.junit.jupiter.api.Assertions.assertNull;
    import static org.junit.jupiter.api.Assertions.assertThrows; 
import org.junit.jupiter.api.Test;

import demifarquhar01.creational_pattern.Builder;
    
    public class BuilderTest {
    
        @Test
        public void testValidAppointmentCreation() {
            String appointmentId = "A001";
            LocalDateTime dateTime = LocalDateTime.of(2025, 4, 20, 10, 0);
            String status = "Booked";
    
            Appointment appointment = new Builder.AppointmentBuilder(appointmentId, dateTime)
                    .status(status)
                    .build();
    
            assertNotNull(appointment);
            assertEquals(appointmentId, appointment.getAppointmentId());
            assertEquals(dateTime, appointment.getDateTime());
            assertEquals(status, appointment.getStatus());
        }
    
        @Test
        public void testNullStatus() {
            String appointmentId = "A002";
            LocalDateTime dateTime = LocalDateTime.of(2025, 4, 21, 11, 0);
    
            Appointment appointment = new Builder.AppointmentBuilder(appointmentId, dateTime)
                    .status(null)
                    .build();
    
            assertNotNull(appointment);
            assertNull(appointment.getStatus());
        }
    
        @Test
        public void testEmptyStatus() {
            String appointmentId = "A003";
            LocalDateTime dateTime = LocalDateTime.of(2025, 4, 22, 14, 0);
    
            Appointment appointment = new Builder.AppointmentBuilder(appointmentId, dateTime)
                    .status("")
                    .build();
    
            assertNotNull(appointment);
            assertEquals("", appointment.getStatus());
        }
    
        @Test
        public void testBuilderThrowsExceptionForNullAppointmentId() {
            LocalDateTime dateTime = LocalDateTime.of(2025, 4, 23, 15, 0);
    
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
                new Builder.AppointmentBuilder(null, dateTime).build();
            });
    
            assertEquals("Appointment ID and DateTime cannot be null", exception.getMessage());
        }
    
        @Test
        public void testBuilderThrowsExceptionForNullDateTime() {
            String appointmentId = "A004";
    
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
                new Builder.AppointmentBuilder(appointmentId, null).build();
            });
    
            assertEquals("Appointment ID and DateTime cannot be null", exception.getMessage());
        }
    }