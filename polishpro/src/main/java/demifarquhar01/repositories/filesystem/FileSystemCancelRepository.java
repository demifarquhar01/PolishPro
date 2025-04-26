package demifarquhar01.repositories.filesystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import demifarquhar01.Cancel;
import demifarquhar01.repositories.CancelRepository;


    
    public class FileSystemCancelRepository implements CancelRepository {
        public FileSystemCancelRepository(String filePath) {
            // Future: Load cancellations from JSON file
        }
    
        @Override
        public void save(Cancel cancel) {
            // Future: write to JSON
        }
    
        @Override
        public Optional<Cancel> findById(String id) {
            return Optional.empty();
        }
    
        @Override
        public List<Cancel> findAll() {
            return new ArrayList<>();
        }
    
        @Override
        public void delete(String id) {
            // Future: delete from JSON
        }
    }
       
    
