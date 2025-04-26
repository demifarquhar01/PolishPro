package demifarquhar01.repositories.filesystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import demifarquhar01.Appointment;
import demifarquhar01.repositories.AppointmentRepository;


    
    public class FileSystemAppointmentRepository implements AppointmentRepository {
        public FileSystemAppointmentRepository(String filePath) {
            // Future: Load appointments from JSON file
        }
    
        @Override
        public void save(Appointment appointment) {
            // Future: write to JSON
        }
    
        @Override
        public Optional<Appointment> findById(String appointmentId) {
            return Optional.empty();
        }
    
        @Override
        public List<Appointment> findAll() {
            return new ArrayList<>();
        }
    
        @Override
        public void delete(String appointmentId) {
            // Future: delete from JSON
        }
    }
       
    
