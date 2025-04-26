package demifarquhar01.repositories.filesystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import demifarquhar01.SalonOwner;
import demifarquhar01.repositories.SalonOwnerRepository;

    public class FileSystemSalonOwnerRepository implements SalonOwnerRepository {
        public FileSystemSalonOwnerRepository(String filePath) {
            // Future: Load salon owners from JSON file
        }
    
        @Override
        public void save(SalonOwner salonOwner) {
            // Future: write to JSON
        }
    
        @Override
        public Optional<SalonOwner> findById(String id) {
            return Optional.empty();
        }
    
        @Override
        public List<SalonOwner> findAll() {
            return new ArrayList<>();
        }
    
        @Override
        public void delete(String id) {
            // Future: delete from JSON
        }
    }
    
    

