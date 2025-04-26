package demifarquhar01.repositories.filesystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import demifarquhar01.Service;
import demifarquhar01.repositories.ServiceRepository;


    
    public class FileSystemServiceRepository implements ServiceRepository {
        public FileSystemServiceRepository(String filePath) {
            // Future: Load nail services from JSON file
        }
    
        @Override
        public void save(Service service) {
            // Future: write to JSON
        }
    
        @Override
        public Optional<Service> findById(String name) {
            return Optional.empty();
        }
    
        @Override
        public List<Service> findAll() {
            return new ArrayList<>();
        }
    
        @Override
        public void delete(String name) {
            // Future: delete from JSON
        }
    }
    
