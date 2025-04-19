package demifarquhar01.creational_pattern;

public class Builder {
        // Make Appointment class static
        public static class Appointment {
            private String appointmentId;
            private String dateTime;
            private String client;
            private String technician;
            private String service;
    
            // Private constructor to be used by the builder
            private Appointment(AppointmentBuilder builder) {
                this.appointmentId = builder.appointmentId;
                this.dateTime = builder.dateTime;
                this.client = builder.client;
                this.technician = builder.technician;
                this.service = builder.service;
            }
    
            @Override
            public String toString() {
                return "Appointment{" +
                        "appointmentId='" + appointmentId + '\'' +
                        ", dateTime='" + dateTime + '\'' +
                        ", client='" + client + '\'' +
                        ", technician='" + technician + '\'' +
                        ", service='" + service + '\'' +
                        '}';
            }
        }
    
        public static class AppointmentBuilder {
            private String appointmentId;
            private String dateTime;
            private String client;
            private String technician;
            private String service;
    
            // Required fields
            public AppointmentBuilder(String appointmentId, String dateTime) {
                this.appointmentId = appointmentId;
                this.dateTime = dateTime;
            }
    
            // Optional fields
            public AppointmentBuilder client(String client) {
                this.client = client;
                return this;
            }
    
            public AppointmentBuilder technician(String technician) {
                this.technician = technician;
                return this;
            }
    
            public AppointmentBuilder service(String service) {
                this.service = service;
                return this;
            }
    
            // Build method to create an Appointment object
            public Appointment build() {
                return new Appointment(this);
            }
        }
    
        public static void main(String[] args) {
            // Using the builder to create an Appointment object
            Appointment appointment = new AppointmentBuilder("A001", "2025-04-20 10:00")
                    .client("John Doe")
                    .technician("Alice")
                    .service("Manicure")
                    .build();
    
            // Print the appointment details
            System.out.println(appointment);
        }
    }
    