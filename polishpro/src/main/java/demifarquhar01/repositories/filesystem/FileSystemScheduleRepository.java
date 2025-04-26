package demifarquhar01.repositories.filesystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import demifarquhar01.Schedule;
import demifarquhar01.repositories.ScheduleRepository;

    
    public class FileSystemScheduleRepository implements ScheduleRepository {
        public FileSystemScheduleRepository(String filePath) {
            // Future: Load schedules from JSON file
        }
    
        @Override
        public void save(Schedule schedule) {
            // Future: write to JSON
        }
    
        @Override
        public Optional<Schedule> findById(String id) {
            return Optional.empty();
        }
    
        @Override
        public List<Schedule> findAll() {
            return new ArrayList<>();
        }
    
        @Override
        public void delete(String id) {
            // Future: delete from JSON
        }
    }
       
    
