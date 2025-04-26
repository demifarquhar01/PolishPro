package demifarquhar01.repositories.inmemory;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import demifarquhar01.Appointment;
import demifarquhar01.repositories.AppointmentRepository;

    
public class InMemoryAppointmentRepository implements AppointmentRepository {
        private final Map<String, Appointment> storage;

    public InMemoryAppointmentRepository() {
        this.storage = new HashMap<>();
    }
    
        @Override
        public void save(Appointment appointment) {
            storage.put(appointment.getAppointmentId(), appointment);
        }
    
        @Override
        public Optional<Appointment> findById(String appointmentId) {
            return Optional.ofNullable(storage.get(appointmentId));
        }
    
        @Override
        public List<Appointment> findAll() {
            return new ArrayList<>(storage.values());
        }
    
        @Override
        public void delete(String appointmentId) {
            storage.remove(appointmentId);
        }
    }
     
