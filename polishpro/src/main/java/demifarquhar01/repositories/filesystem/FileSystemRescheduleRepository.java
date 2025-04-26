package demifarquhar01.repositories.filesystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import demifarquhar01.Reschedule;
import demifarquhar01.repositories.RescheduleRepository;

    
    public class FileSystemRescheduleRepository implements RescheduleRepository {
        public FileSystemRescheduleRepository(String filePath) {
            // Future: Load reschedules from JSON file
        }
    
        @Override
        public void save(Reschedule reschedule) {
            // Future: write to JSON
        }
    
        @Override
        public Optional<Reschedule> findById(String id) {
            return Optional.empty();
        }
    
        @Override
        public List<Reschedule> findAll() {
            return new ArrayList<>();
        }
    
        @Override
        public void delete(String id) {
            // Future: delete from JSON
        }
    }
       
    
